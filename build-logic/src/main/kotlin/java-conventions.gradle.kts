plugins {
    id("base-conventions")
    id("java-library")
    id("net.kyori.indra")
}

indra {
    javaVersions {
        target(19)
    }
}

repositories {
    mavenCentral()
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
