package cpufeatures;

import java.util.Locale;

/**
 * Processor architecture.
 */
public enum CpuArchitecture {
    /** Unknown architecture */
    UNKNOWN,
    /** AArch64 */
    AARCH64,
    /** ARM */
    ARM,
    /** X86 */
    X86;

    /**
     * Gets the processor architecture that the machine running this JVM is on.
     * @return Architecture.
     */
    public static CpuArchitecture get() {
        String arch = System.getProperty("os.arch")
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9]+", "");
        return switch (arch) {
            case "aarch64" -> CpuArchitecture.AARCH64;
            case "arm", "arm32" -> CpuArchitecture.ARM;
            case "x8664", "amd64", "ia32e", "em64t", "x64" -> CpuArchitecture.X86;
            default -> CpuArchitecture.UNKNOWN;
        };
    }
}
