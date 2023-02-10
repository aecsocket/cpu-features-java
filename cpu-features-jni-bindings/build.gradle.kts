plugins {
    id("base-conventions")
    id("cpp-library")
}

val baseProject: Project = projects.cpuFeaturesJni.dependencyProject

library {
    binaries.configureEach {
        val compileTask = compileTask.get()
        compileTask.compilerArgs.add("--std=c++11")
        // include generated native code
        compileTask.dependsOn(baseProject.tasks["compileJava"])
        compileTask.includes("${baseProject.buildDir}/generated/sources/annotationProcessor/java/main/cpufeatures/")

        // include JNI
        val os = targetPlatform.targetMachine.operatingSystemFamily
        compileTask.includes.from(baseProject.tasks.named<WriteToolchainPath>("writeToolchainPath").flatMap {
            it.outputFile.map { f -> f.asFile.readText() + "/include" }
        })
        compileTask.includes.from(baseProject.tasks.named<WriteToolchainPath>("writeToolchainPath").flatMap {
            it.outputFile.map { f ->
                val javaInclude = f.asFile.readText() + "/include"
                when {
                    os.isLinux -> "$javaInclude/linux"
                    os.isWindows -> "$javaInclude/win32"
                    os.isMacOs -> "$javaInclude/darwin"
                    else -> throw IllegalStateException("Unsupported OS $os")
                }
            }
        })

        // include cpu_features
        compileTask.includes("$rootDir/cpu_features/include")
    }
}

tasks {
    val os = org.gradle.internal.os.OperatingSystem.current()
    val libName = when {
        os.isLinux -> "libcpu_features.a"
        os.isWindows -> "cpu_features.dll"
        os.isMacOsX -> "libcpu_features.a"
        else -> throw IllegalStateException("Unsupported OS $os")
    }
    withType<LinkSharedLibrary> {
        libs.from("$rootDir/cpu_features/build/$libName")
    }
}
