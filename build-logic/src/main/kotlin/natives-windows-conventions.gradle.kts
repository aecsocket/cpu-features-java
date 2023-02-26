plugins {
    id("natives-conventions")
}

extensions.getByType<NativesExtension>().apply {
    platformPredicate.set { it.isWindows }
    generator.set("Ninja")
    generatorBinary.set("ninja")
    sourceLibraryName.set("cpu_features.dll")
}
