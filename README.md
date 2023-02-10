<div align="center">

# CpuFeaturesJni
[![License](https://img.shields.io/github/license/aecsocket/cpu-features-jni)](LICENSE)
[![CI](https://img.shields.io/github/actions/workflow/status/aecsocket/cpu-features-jni/build.yml)](https://github.com/aecsocket/cpu-features-jni/actions/workflows/build.yml)
![Release](https://img.shields.io/maven-central/v/io.github.aecsocket/cpu-features-jni?label=release)
![Snapshot](https://img.shields.io/nexus/s/io.github.aecsocket/cpu-features-jni?label=snapshot&server=https%3A%2F%2Fs01.oss.sonatype.org)

Java bindings for [Google cpu_features](https://github.com/google/cpu_features)

---

</div>

## Usage

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.aecsocket", "cpu-features-jni", "VERSION")
    runtimeOnly("io.github.aecsocket", "cpu-features-jni-natives-linux", "VERSION")
    runtimeOnly("io.github.aecsocket", "cpu-features-jni-natives-windows", "VERSION")
    runtimeOnly("io.github.aecsocket", "cpu-features-jni-natives-macos", "VERSION")
    runtimeOnly("io.github.aecsocket", "cpu-features-jni-natives-macos-arm64", "VERSION")
}
```

Usage is very similar to cpu_features. See [HelloCpuFeatures.java](cpu-features-jni-test/src/test/java/cpufeatures/HelloCpuFeatures.java) to get a minimal
implementation.

### Entry point

The class `cpufeatures.CpuFeatures` is your entry point to the library. Firstly run `CpuFeatures.load()` to load the
native libraries from the jar (in `cpufeatures/`), or load them yourself using `System.load`.

### Getting CPU info

```java
CpuArchitecture arch = CpuFeatures.getArchitecture();
switch (arch) {
    X86 -> {
        X86Info info = CpuFeatures.getX86Info();
        System.out.println(info.vendor);
    }
    ARM -> {
        ArmInfo info = CpuFeatures.getArmInfo();
        System.out.println(info.implementer);
    }
    // ...
}
```

### Querying CPU features

```java
public static boolean useAVX2 = false;

public static void init(){
    X86Info info = CpuFeatures.getX86Info();
    useAVX2 = info.features.avx2;
}
```

## Building from source

```sh
git clone https://github.com/aecsocket/cpu-features-jni
cd cpu-features-jni
git submodule update --init
./gradlew generateNatives build
```
