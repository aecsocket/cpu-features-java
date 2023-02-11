plugins {
    id("natives-conventions")
}

natives {
    platformPredicate.set { it.isWindows }
    bindingsFileName.set("cpu-features-jni-bindings.dll")
    destInnerDir.set("windows")
}
