plugins {
    id("java-conventions")
}

dependencies {
    implementation(projects.cpuFeaturesJni)

    testImplementation(libs.jUnitJupiterApi)
    testImplementation(libs.jUnitJupiterEngine)
    testRuntimeOnly(projects.cpuFeaturesJniNatives.linux)
    testRuntimeOnly(projects.cpuFeaturesJniNatives.windows)
    testRuntimeOnly(projects.cpuFeaturesJniNatives.macos)
    testRuntimeOnly(projects.cpuFeaturesJniNatives.macosArm64)
}
