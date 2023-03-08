import gradle.kotlin.dsl.accessors._a3cef13561c8f096ac9de7f8d52a5c05.signing

plugins {
    id("base-conventions")
    id("java-library")
    id("net.kyori.indra")
    signing apply false
}

indra {
    javaVersions {
        target(19)
    }
}

repositories {
    mavenCentral()
}

signing {
    val signingKey = findProperty("signingKey") as? String
    val signingPassword = findProperty("signingPassword") as? String
    if (signingKey != null) {
        println("${project.name}: Signing with in-memory PGP keys")
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
}

tasks {
    withType<JavaCompile> {
        options.compilerArgs.addAll(listOf("--enable-preview"))
    }

    javadoc {
        (options as CoreJavadocOptions).apply {
            addBooleanOption("-enable-preview", true)
        }
    }

    withType<Test> {
        jvmArgs("--enable-preview", "--enable-native-access=ALL-UNNAMED")
    }
}
