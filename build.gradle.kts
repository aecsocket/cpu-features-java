plugins {
    id("parent-conventions")
    id("java-conventions")
    id("publishing-conventions")
}

group = "io.github.aecsocket"
version = "2.0.0-SNAPSHOT"
description = "Java bindings for Google cpu_features"

dependencies {
    implementation(projects.cpuFeaturesJavaNatives)
    compileOnlyApi(libs.findBugs)

    testImplementation(libs.findBugs)
    testImplementation(libs.jUnitJupiterApi)
    testImplementation(libs.jUnitJupiterEngine)
}

tasks {
    tasks {
        withType<JavaCompile> {
            options.compilerArgs.addAll(listOf("--enable-preview"))
        }
    }

    test {
        // todo
        systemProperty("java.library.path", "$cpuFeaturesDir/build")
        jvmArgs("--enable-preview", "--enable-native-access=ALL-UNNAMED")
    }
}
