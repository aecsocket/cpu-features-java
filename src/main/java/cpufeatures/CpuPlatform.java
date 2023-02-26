package cpufeatures;

import java.util.Locale;

public enum CpuPlatform {
    LINUX,
    WINDOWS,
    MACOS;

    public static CpuPlatform get() {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);

        if (os.contains("linux")) return LINUX;
        if (os.contains("windows")) return WINDOWS;
        if (os.contains("mac os x") || os.contains("darwin")) return MACOS;
        throw new RuntimeException("Unsupported OS " + System.getProperty("os.name"));
    }
}
