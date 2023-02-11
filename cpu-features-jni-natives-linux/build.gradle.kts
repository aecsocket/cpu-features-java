plugins {
    id("natives-conventions")
}

natives {
    platformPredicate.set { it.isLinux }
    bindingsFileName.set("libcpu-features-jni-bindings.so")
    destInnerDir.set("linux")
}
