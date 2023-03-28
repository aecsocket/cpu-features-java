plugins {
    id("net.kyori.indra.git")
}

group = rootProject.group
version = rootProject.version
description = rootProject.description

extensions.findByType<SigningExtension>()?.apply {
    val signingKey = findProperty("signingKey") as? String
    val signingPassword = findProperty("signingPassword") as? String
    if (signingKey != null) {
        println("${project.name}: Signing with in-memory PGP keys")
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
}
