plugins {
    id("publishing-conventions")
}

dependencies {
    implementation(libs.findBugs)
    implementation(libs.jniGlueAnnotations)
    annotationProcessor(libs.jniGlueProcessor)
}
