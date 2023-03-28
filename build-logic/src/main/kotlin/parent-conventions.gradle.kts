plugins {
    id("net.kyori.indra.publishing.sonatype")
}

indraSonatype {
    useAlternateSonatypeOSSHost("s01")
}

afterEvaluate {
    tasks.register("printVersionType") {
        doFirst {
            println(if (net.kyori.indra.util.Versioning.isSnapshot(project)) "snapshot" else "release")
        }
    }
}
