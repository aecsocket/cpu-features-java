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

rootProject.name = "cpu-features-jni-parent"

include("cpu-features-jni")
include("cpu-features-jni-bindings")
include("cpu-features-jni-test")
