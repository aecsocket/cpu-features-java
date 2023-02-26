<div align="center">

# CpuFeaturesJava
[![License](https://img.shields.io/github/license/aecsocket/cpu-features-java)](LICENSE)
[![CI](https://img.shields.io/github/actions/workflow/status/aecsocket/cpu-features-java/build.yml)](https://github.com/aecsocket/cpu-features-java/actions/workflows/build.yml)
![Release](https://img.shields.io/maven-central/v/io.github.aecsocket/cpu-features-java?label=release)
![Snapshot](https://img.shields.io/nexus/s/io.github.aecsocket/cpu-features-java?label=snapshot&server=https%3A%2F%2Fs01.oss.sonatype.org)

Java bindings for [Google cpu_features](https://github.com/google/cpu_features)

---

</div>

Even though Java is a "write once, run anywhere" language, often a library will still want to use a native library,
which is not only OS-specific but also host-specific. These libraries may be compiled with different CPU flags enabled,
such as AVX2 or F16C, to utilise different CPU features. When loading a library from Java, the program has no clue
which features may be supported, so must rely on the most accessible version - which is often the slowest. Using
cpu_features, Java programs can detect which features the host CPU supports and load different native libraries based
on this info.

## Coverage

Platforms:
- [x] Linux (x86)
- [x] Windows (x86)
- [x] MacOS (x86)

Architectures:
- [ ] AArch64
- [ ] ARM
- [x] X86

## Usage

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.aecsocket", "cpu-features-java", "VERSION")
    // native libraries
    runtimeOnly("io.github.aecsocket", "cpu-features-java-natives-linux-x86", "VERSION")
    runtimeOnly("io.github.aecsocket", "cpu-features-java-natives-windows-x86", "VERSION")
    runtimeOnly("io.github.aecsocket", "cpu-features-java-natives-macos-x86", "VERSION")
}
```

Usage is very similar to cpu_features. See [HelloCpuFeatures.java](src/test/java/cpufeatures/HelloCpuFeatures.java)
to get a minimal implementation.

### Getting CPU info

```java
// If using the native library dependencies:
CpuFeatures.load();
// Otherwise load the libraries yourself:
// System.loadLibrary("cpu_features");

// CpuFeatures is the entry point to the application
CpuArchitecture arch = CpuFeatures.getArchitecture();
switch (arch) {
    case ARM -> {
        // The various -Info classes hold all CPU info
        ArmInfo info = ArmInfo.get();
        System.out.println(info.implementer);
    }
    case X86 -> {
        X86Info info = X86Info.get()
        System.out.println(info.vendor);
    }
    // ...
}
```

### Querying CPU features

```java
public static boolean useAVX2 = false;

public static void init() {
    X86Info info = X86Info.get();
    // Prefer accessing `features` directly over using an enum
    useAVX2 = info.features().avx2();
    // useAVX2 = X86Feature.AVX2.in(info.features());

    Set<X86Feature> features = info.featureSet();
    System.out.println("features: " + features);
}
```

## Building from source

```sh
git clone https://github.com/aecsocket/cpu-features-java
cd cpu-features-java
git submodule update --init
./gradlew build
```
