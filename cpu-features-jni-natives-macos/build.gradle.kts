plugins {
    id("java-conventions")
}

val bindings = projects.cpuFeaturesJniBindings.dependencyProject

dependencies {
    implementation(projects.cpuFeaturesJni)
}

tasks {
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
