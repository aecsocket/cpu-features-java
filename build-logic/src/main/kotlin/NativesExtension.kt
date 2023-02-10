import org.gradle.api.provider.Property

abstract class NativesExtension {
    abstract val platform: Property<String>
    abstract val bindingsFileName: Property<String>
}
