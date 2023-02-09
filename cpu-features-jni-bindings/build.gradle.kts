import org.gradle.internal.jvm.Jvm

plugins {
    id("base-conventions")
    id("cpp-library")
}

val cpuFeaturesJni = projects.cpuFeaturesJni.dependencyProject

library {
    binaries.configureEach {
        val compileTask = compileTask.get()
        // include generated native code
        compileTask.dependsOn(cpuFeaturesJni.tasks["compileJava"])
        compileTask.includes("${cpuFeaturesJni.buildDir}/generated/sources/annotationProcessor/java/main/cpufeatures/")

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
    val os = org.gradle.internal.os.OperatingSystem.current()
    val libName = when {
        os.isLinux -> "libcpu_features.a"
        os.isWindows -> "cpu_features.dll"
        os.isMacOsX -> "libcpu_features.dylib"
        else -> throw IllegalStateException("Unsupported OS $os")
    }
    withType<LinkSharedLibrary> {
        libs.from("$rootDir/cpu_features/build/$libName")
    }
}
