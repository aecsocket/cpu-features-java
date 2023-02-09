plugins {
    id("java-conventions")
}

dependencies {
    implementation(projects.cpuFeaturesJni)

    testImplementation(libs.jUnitJupiterApi)
    testImplementation(libs.jUnitJupiterEngine)
    testRuntimeOnly(projects.cpuFeaturesJniNativesLinux)
    testRuntimeOnly(projects.cpuFeaturesJniNativesWindows)
    testRuntimeOnly(projects.cpuFeaturesJniNativesMacos)
    testRuntimeOnly(projects.cpuFeaturesJniNativesMacosArm64)
}
