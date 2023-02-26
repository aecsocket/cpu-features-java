package cpufeatures;

import java.util.Locale;

public final class CpuFeatures {
    private CpuFeatures() {}

    public static CpuArchitecture getArchitecture() {
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
