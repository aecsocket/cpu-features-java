plugins {
    id("extract-conventions")
}

tasks {
    jextract {
        header("$cpuFeaturesDir/include/cpuinfo_x86.h") {
            libraries.set(listOf("cpu_features"))
            targetPackage.set("cpufeatures.natives")
            className.set("CpuInfoX86")
        }
    }
}
