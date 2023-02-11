import org.gradle.internal.os.OperatingSystem

plugins {
    id("java-conventions")
}

val bindings = project(":cpu-features-jni-bindings")
val nativesExt = extensions.create("natives", NativesExtension::class)

dependencies {
    implementation(project(":cpu-features-jni"))
}

afterEvaluate {
    val os = OperatingSystem.current()
    if (nativesExt.platformPredicate.get()(os)) {
        apply(plugin = "publishing-conventions")

        tasks {
            register<Exec>("generateNatives") {
                group = "natives"
                val buildDir = "$rootDir/cpu_features/"

                workingDir = File(buildDir)
                // TODO there is a cleaner way to do this
                // Windows requires `-G=Ninja` because otherwise it tries (and fails) to build with nmake
                commandLine = when {
                    os.isWindows -> listOf(
                        "cmake",
                        "-S.",
                        "-Bbuild",
                        "-DBUILD_TESTING=OFF",
                        "-DCMAKE_BUILD_TYPE=Release",
                        "-G=Ninja"
                    )

                    else -> listOf("cmake", "-S.", "-Bbuild", "-DBUILD_TESTING=OFF", "-DCMAKE_BUILD_TYPE=Release")
                }

                doLast {
                    exec {
                        workingDir = File(buildDir)
                        commandLine = listOf("cmake", "--build", "build", "--config", "Release", "-j")
                    }
                }
            }

            jar {
                bindings.tasks.withType<LinkSharedLibrary> {
                    this@jar.dependsOn(this)
                }
                from("${bindings.buildDir}/lib/main/debug/${nativesExt.bindingsFileName.get()}") {
                    into("cpufeatures/${nativesExt.destInnerDir.get()}")
                }
            }
        }
    }
}
