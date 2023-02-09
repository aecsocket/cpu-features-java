plugins {
    id("publishing-conventions")
}

dependencies {
    implementation(libs.findBugs)
    implementation(libs.jniGlueAnnotations)
    annotationProcessor(libs.jniGlueProcessor)
}

listOf(
    projects.cpuFeaturesJniNativesLinux,
    projects.cpuFeaturesJniNativesWindows,
    projects.cpuFeaturesJniNativesMacos,
    projects.cpuFeaturesJniNativesMacosArm64
).forEach {
    evaluationDependsOn(it.dependencyProject.path)
}

indra {
    configurePublications {
        artifact(projects.cpuFeaturesJniNativesLinux.dependencyProject.tasks.jar) {
            classifier = "natives-linux"
        }
        artifact(projects.cpuFeaturesJniNativesWindows.dependencyProject.tasks.jar) {
            classifier = "natives-windows"
        }
        artifact(projects.cpuFeaturesJniNativesMacos.dependencyProject.tasks.jar) {
            classifier = "natives-macos"
        }
        artifact(projects.cpuFeaturesJniNativesMacosArm64.dependencyProject.tasks.jar) {
            classifier = "natives-macos-arm64"
        }
    }
}
