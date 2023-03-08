plugins {
    id("net.kyori.indra.publishing")
}

signing {
    val signingKey = findProperty("signingKey") as? String
    val signingPassword = findProperty("signingPassword") as? String
    if (signingKey != null) {
        println("Signing with in-memory PGP keys")
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
}

indra {
    github("aecsocket", "cpu-features-java")
    mitLicense()

    configurePublications {
        pom {
            developers {
                developer {
                    name.set("aecsocket")
                    email.set("aecsocket@tutanota.com")
                    url.set("https://github.com/aecsocket")
                }
            }
        }
    }
}
