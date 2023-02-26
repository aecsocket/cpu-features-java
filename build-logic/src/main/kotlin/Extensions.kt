import org.gradle.api.Project
import java.io.File

val Project.cpuFeaturesDir: File
    get() = rootDir.resolve("cpu_features")
