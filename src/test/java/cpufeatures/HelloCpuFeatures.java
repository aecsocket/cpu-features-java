package cpufeatures;

import cpufeatures.x86.X86Info;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public final class HelloCpuFeatures {
    private static String format(int value) {
        return String.format("%3d (0x%02x)", value, value);
    }

    private static List<String> format(Collection<? extends Enum<?>> enums) {
        return enums.stream()
                .map(Enum::name)
                .sorted().toList();
    }

    @Test
    public void helloWorld() {
        CpuFeatures.load();

        var keys = new LinkedHashMap<String, String>();

        CpuArchitecture arch = CpuArchitecture.get();
        switch (arch) {
            case AARCH64 -> throw new UnsupportedOperationException();
            case ARM -> throw new UnsupportedOperationException();
            case X86 -> {
                X86Info info = X86Info.get();
                keys.put("arch", "x86");
                keys.put("family", format(info.family()));
                keys.put("model", format(info.model()));
                keys.put("stepping", format(info.stepping()));
                keys.put("vendor", info.vendor());
                keys.put("brand", info.brandString());
                keys.put("uarch", info.uarch().name());
                var featureSet = format(info.featureSet());
                keys.put("flags", "(" + featureSet.size() + ") " + featureSet);
            }
            default -> throw new RuntimeException("Invalid architecture " + arch);
        }

        for (var entry : keys.entrySet()) {
            System.out.printf("%10s: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
