plugins {
    id("parent-conventions")
    id("java-conventions")
}

publishCore()

group = "io.github.aecsocket"
version = "2.0.1-SNAPSHOT"
description = "Java bindings for Google cpu_features"

dependencies {
    implementation(projects.cpuFeaturesJavaHeaders)
    compileOnlyApi(libs.findBugs)

    testImplementation(libs.jUnitJupiterApi)
    testImplementation(libs.jUnitJupiterEngine)
    testImplementation(libs.findBugs)
    testRuntimeOnly(projects.cpuFeaturesJavaNativesLinuxX86)
    testRuntimeOnly(projects.cpuFeaturesJavaNativesWindowsX86)
    testRuntimeOnly(projects.cpuFeaturesJavaNativesMacosX86)
}

tasks.register("printVersionType") {
    doFirst {
        println(if (net.kyori.indra.util.Versioning.isSnapshot(project)) "snapshot" else "release")
    }
}
