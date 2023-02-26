plugins {
    id("natives-conventions")
}

extensions.getByType<NativesExtension>().apply {
    platformPredicate.set { it.isMacOsX }
    generator.set("Unix Makefiles")
    generatorBinary.set("make")
    sourceLibraryName.set("libcpu_features.dylib")
}
