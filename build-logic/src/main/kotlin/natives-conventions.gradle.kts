import org.gradle.internal.os.OperatingSystem

plugins {
    id("java-conventions")
}

val nativesExt = extensions.create("natives", NativesExtension::class)
val workers = kotlin.math.min(32, Runtime.getRuntime().availableProcessors())
val nativesBuildDir = "$buildDir/natives"

afterEvaluate {
    val os = OperatingSystem.current()
    if (!nativesExt.platformPredicate.get().test(os)) return@afterEvaluate

    // only publish if we can actually build the artifact
    apply(plugin = "publishing-conventions")
    configurePublishing()

    tasks {
        val assembleNatives = register<Exec>("assembleNatives") {
            group = "build natives"

            workingDir = file(cpuFeaturesDir)
            commandLine = listOf(
                "cmake",
                "-S", ".",                                  // source at `cpu_features/`
                "-B", file(nativesBuildDir).absolutePath,   // put makefiles into this project's `build/natives/`
                "-G", nativesExt.generator.get(),           // use the platform-specific generator
                "-DBUILD_TESTING=OFF",                      // no testing
                "-DCMAKE_BUILD_TYPE=Release",               // release build type
                "-DBUILD_SHARED_LIBS=ON",                   // make a platform-specific library (`.so` etc.), not a `.a`
            )

            doLast {
                exec {
                    workingDir = file(nativesBuildDir)
                    commandLine = listOf(
                        nativesExt.generatorBinary.get(),
                        "-j$workers"
                    )
                }
            }
        }

        jar {
            dependsOn(assembleNatives.get())
            from("$nativesBuildDir/${nativesExt.sourceLibraryName.get()}")
            into("cpufeatures/${nativesExt.destDir.get()}")
        }
    }
}
