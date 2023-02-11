plugins {
    id("natives-conventions")
}

natives {
    platform.set("macos")
    bindingsFileName.set("libcpu-features-jni-bindings.dylib")
    destInnerDir.set("macos")
}
