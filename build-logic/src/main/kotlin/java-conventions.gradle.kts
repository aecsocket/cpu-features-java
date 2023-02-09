plugins {
    id("base-conventions")
    id("java-library")
    id("net.kyori.indra")
}

indra {
    javaVersions {
        minimumToolchain(15)
        target(15)
    }
}

repositories {
    mavenCentral()
}
