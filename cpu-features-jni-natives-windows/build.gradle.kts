plugins {
    id("natives-conventions")
}

natives {
    platform.set("windows")
    bindingsFileName.set("cpu-features-jni-bindings.dll")
    destInnerDir.set("windows")
}
