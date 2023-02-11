plugins {
    id("parent-conventions")
}

val nativesLinux      = projects.cpuFeaturesJniNativesLinux.dependencyProject
val nativesWindows    = projects.cpuFeaturesJniNativesWindows.dependencyProject
val nativesMacos      = projects.cpuFeaturesJniNativesMacos.dependencyProject
val nativesMacosArm64 = projects.cpuFeaturesJniNativesMacosArm64.dependencyProject

group = "io.github.aecsocket"
version = "1.0.0-SNAPSHOT"
description = "Java bindings for Google cpu_features"

tasks.register("printVersionType") {
    doFirst {
        println(if (net.kyori.indra.util.Versioning.isRelease(project)) "release" else "snapshot")
    }
}
