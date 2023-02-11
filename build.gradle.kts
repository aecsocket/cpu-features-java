plugins {
    id("parent-conventions")
}

group = "io.github.aecsocket"
version = "1.0.1-SNAPSHOT"
description = "Java bindings for Google cpu_features"

tasks.register("printVersionType") {
    doFirst {
        println(if (net.kyori.indra.util.Versioning.isRelease(project)) "release" else "snapshot")
    }
}
