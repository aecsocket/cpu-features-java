plugins {
    id("java-conventions")
}

dependencies {
    implementation(projects.cpuFeaturesJni)

    testImplementation(libs.jUnitJupiterApi)
    testImplementation(libs.jUnitJupiterEngine)
}
