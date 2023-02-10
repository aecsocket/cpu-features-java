plugins {
    id("parent-conventions")
}

val nativesLinux      = projects.cpuFeaturesJniNativesLinux.dependencyProject
val nativesWindows    = projects.cpuFeaturesJniNativesWindows.dependencyProject
val nativesMacos      = projects.cpuFeaturesJniNativesMacos.dependencyProject
val nativesMacosArm64 = projects.cpuFeaturesJniNativesMacosArm64.dependencyProject

group = "io.github.aecsocket"
version = "0.1.0-SNAPSHOT"
description = "Java bindings for Google cpu_features"

tasks {
    register("generateNatives") {
        val os = org.gradle.internal.os.OperatingSystem.current()
        when {
            os.isLinux -> dependsOn(nativesLinux.tasks["generateNativesLinux"])
            os.isWindows -> dependsOn(nativesWindows.tasks["generateNativesWindows"])
            os.isMacOsX -> {
                dependsOn(nativesMacos.tasks["generateNativesMacos"])
                dependsOn(nativesMacosArm64.tasks["generateNativesMacos"])
            }
            else -> throw IllegalStateException("Unsupported OS $os")
        }
    }
}
