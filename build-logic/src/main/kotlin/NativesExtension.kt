import org.gradle.api.provider.Property
import org.gradle.api.tasks.Optional

abstract class NativesExtension {
    abstract val platform: Property<String>
    abstract val bindingsFileName: Property<String>
    abstract val destInnerDir: Property<String>
}
