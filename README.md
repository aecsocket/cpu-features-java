CpuFeaturesJni
===

Java bindings for [Google cpu_features](https://github.com/google/cpu_features)

## Usage

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.aecsocket", "cpu-features-jni", "VERSION")
}
```

## Building from source

```sh
git clone https://github.com/aecsocket/cpu-features-jni
cd cpu-features-jni
git submodule update --init
./gradlew generateNatives build
```
