plugins {
    id("java-conventions")
}

if (!ci.get() || ciPublishApi.get()) {
    plugins.apply("publishing-conventions")
}

dependencies {
    compileOnlyApi(libs.findBugs)
    testImplementation(libs.findBugs)
    implementation(libs.jniGlueAnnotations)
    annotationProcessor(libs.jniGlueProcessor)
}

tasks.register("writeToolchainPath", WriteToolchainPath::class) {
    toolchainSpec.set(java.toolchain)
    outputFile.set(layout.buildDirectory.file("javaToolchainJavaHome.txt"))
}
