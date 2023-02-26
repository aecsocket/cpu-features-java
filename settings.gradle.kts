enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

plugins {
    id("ca.stellardrift.polyglot-version-catalogs") version "6.0.1"
}

rootProject.name = "cpu-features-java"

include("cpu-features-java-headers")
include("cpu-features-java-natives-linux-x86")
include("cpu-features-java-natives-windows-x86")
include("cpu-features-java-natives-macos-x86")
include("cpu-features-java-natives-macos-aarch64")
