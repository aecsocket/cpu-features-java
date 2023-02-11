import org.gradle.internal.jvm.Jvm

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
        val javaInclude = "${Jvm.current().javaHome}/include"
        if (!File(javaInclude).exists())
            throw IllegalStateException("JDK include headers not found at $javaInclude")
        compileTask.includes(javaInclude)
        val os = targetPlatform.targetMachine.operatingSystemFamily
        when {
            os.isLinux -> compileTask.includes("$javaInclude/linux")
            os.isWindows -> compileTask.includes("$javaInclude/win32")
            os.isMacOs -> compileTask.includes("$javaInclude/darwin")
            else -> throw IllegalStateException("Unsupported OS $os")
        }

        // include cpu_features
        compileTask.includes("$rootDir/cpu_features/include")
    }
}

tasks {
    withType<LinkSharedLibrary> {
        libs.from("$rootDir/cpu_features/build/libcpu_features.a")
    }
}
