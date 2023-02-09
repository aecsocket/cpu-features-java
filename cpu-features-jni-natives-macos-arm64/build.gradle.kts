plugins {
    id("java-conventions")
}

val bindings = projects.cpuFeaturesJniBindings.dependencyProject

dependencies {
    implementation(projects.cpuFeaturesJni)
}

tasks {
    register<Exec>("generateNativesMacos") {
        group = "natives"
        val buildDir = "$rootDir/cpu_features/"

        workingDir = File(buildDir)
        commandLine = listOf("cmake", "-S.", "-Bbuild", "-DBUILD_TESTING=OFF", "-DCMAKE_BUILD_TYPE=Release")

        doLast {
            exec {
                workingDir = File(buildDir)
                commandLine = listOf("cmake", "--build", "build", "--config", "Release", "-j")
            }
        }
    }

    jar {
        val jarTask = this
        bindings.tasks.withType<LinkSharedLibrary> {
            jarTask.mustRunAfter(this)
        }

        from("${bindings.buildDir}/lib/main/debug/libcpu-features-jni-bindings.dylib") {
            into("cpufeatures/")
        }
    }
}
