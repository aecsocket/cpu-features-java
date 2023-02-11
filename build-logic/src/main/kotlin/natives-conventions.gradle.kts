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
            commandLine = listOf("cmake", "-S.", "-Bbuild", "-DBUILD_TESTING=OFF", "-DCMAKE_BUILD_TYPE=Release")

            doLast {
                exec {
                    workingDir = File(buildDir)
                    commandLine = listOf("cmake", "--build", "build", "--config", "Release", "-j")
                }
            }
        }
        jar {
            bindings.tasks.withType<LinkSharedLibrary> {
                this@jar.mustRunAfter(this)
            }
            from("${bindings.buildDir}/lib/main/debug/${nativesExt.bindingsFileName.get()}") {
                var dest = "cpufeatures/"
                if (nativesExt.destInnerDir.isPresent) {
                    dest += "${nativesExt.destInnerDir.get()}/"
                }
                into(dest)
            }
        }
    }
}
