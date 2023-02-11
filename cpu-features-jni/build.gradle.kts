plugins {
    id("publishing-conventions")
}

dependencies {
    implementation(libs.findBugs)
    implementation(libs.jniGlueAnnotations)
    annotationProcessor(libs.jniGlueProcessor)
}

tasks.register("writeToolchainPath", WriteToolchainPath::class) {
    toolchainSpec.set(java.toolchain)
    outputFile.set(layout.buildDirectory.file("javaToolchainJavaHome.txt"))
}
