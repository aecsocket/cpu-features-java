plugins {
    id("natives-conventions")
}

natives {
    platform.set("linux")
    bindingsFileName.set("libcpu-features-jni-bindings.so")
}
