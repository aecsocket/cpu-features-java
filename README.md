<div align="center">

# CpuFeaturesJni
[![License](https://img.shields.io/github/license/aecsocket/cpu-features-jni)](LICENSE)
[![CI](https://img.shields.io/github/actions/workflow/status/aecsocket/cpu-features-jni/build.yml)](https://github.com/aecsocket/cpu-features-jni/actions/workflows/build.yml)
![Release](https://img.shields.io/maven-central/v/io.github.aecsocket/cpu-features-jni?label=release)
![Snapshot](https://img.shields.io/nexus/s/io.github.aecsocket/cpu-features-jni?label=snapshot&server=https%3A%2F%2Fs01.oss.sonatype.org)

Java bindings for [Google cpu_features](https://github.com/google/cpu_features)

---

</div>

Even though Java is a "write once, run anywhere" language, often a library will still want to use a native library,
which is not only OS-specific but also host-specific. These libraries may be compiled with different CPU flags enabled,
such as AVX2 or F16C, to utilise different CPU features. When loading a library from Java, the program has no clue
which features may be supported, so must rely on the most accessible version - which is often the slowest. Using
cpu_features, Java programs can detect which features the host CPU supports and load different native libraries based
on this info.

<div style="column-count: 2">

<div>
Architectures:
<ul>
<li>aarch64</li>
<li>arm</li>
<li>riscv</li>
<li>x86</li>
</ul>
</div>

<div>
Platforms:
<ul>
<li>linux</li>
<li>windows</li>
<li>macos</li>
<li>macos-arm64</li>
</ul>
</div>

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

Usage is very similar to cpu_features. See [HelloCpuFeatures.java](cpu-features-jni-test/src/test/java/cpufeatures/HelloCpuFeatures.java)
to get a minimal implementation.

### Getting CPU info

```java
// Load the native libraries from the jar (in `cpufeatures/`)
CpuFeatures.load();
// Or load them manually
// System.load("name-of-lib-file");

// CpuFeatures is the entry point to the application
CpuArchitecture arch = CpuFeatures.getArchitecture();
switch (arch) {
    X86 -> {
        // The various -Info classes hold all CPU info
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

public static void init() {
    X86Info info = CpuFeatures.getX86Info();
    // Prefer accessing `features` directly over using an enum
    useAVX2 = info.features.avx2;
    // useAVX2 = info.has(X86Feature.AVX2);
    
    List<X86Feature> features = info.featureList();
    System.out.println("features: " + features);
}
```

## Building from source

```sh
git clone https://github.com/aecsocket/cpu-features-jni
cd cpu-features-jni
git submodule update --init
./gradlew generateNatives build
```
