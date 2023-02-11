import org.gradle.internal.os.OperatingSystem

plugins {
    id("publishing-conventions")
}

val bindings = project(":cpu-features-jni-bindings")
val nativesExt = extensions.create("natives", NativesExtension::class)

dependencies {
    implementation(project(":cpu-features-jni"))
}

afterEvaluate {
    tasks {
        register<Exec>("generateNatives${nativesExt.platform.get().capitalize()}") {
            group = "natives"
            val buildDir = "$rootDir/cpu_features/"

            workingDir = File(buildDir)
            // TODO there is a cleaner way to do this
            // Windows requires `-G=Ninja` because otherwise it tries (and fails) to build with nmake
            val os = OperatingSystem.current()
            commandLine = when {
                os.isWindows -> listOf("cmake", "-S.", "-Bbuild", "-DBUILD_TESTING=OFF", "-DCMAKE_BUILD_TYPE=Release", "-G=Ninja")
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
