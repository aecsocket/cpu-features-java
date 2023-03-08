plugins {
    id("net.kyori.indra.publishing")
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
