import io.github.krakowski.jextract.JextractTask

plugins {
    id("java-conventions")
}

publishCore()

tasks {
    fun registerGenerateHeaders(platformKey: String, platformName: String) {
        register<JextractTask>("generateHeaders$platformName") {
            toolchain.convention(org.gradle.internal.jvm.Jvm.current().javaHome.absolutePath)

            header("$cpuFeaturesDir/include/cpuinfo_$platformKey.h") {
                this.targetPackage.set("cpufeatures.headers.$platformKey")
                this.className.set("CpuInfo$platformName")
            }

            doLast {
                copy {
                    from("${outputDir.get()}")
                    into("$projectDir/src/main/java")
                }
            }
        }
    }

    // uncomment the headers for your machine's architecture

    registerGenerateHeaders("x86", "X86")
    //registerGenerateHeaders("aarch64", "Aarch64")
}
