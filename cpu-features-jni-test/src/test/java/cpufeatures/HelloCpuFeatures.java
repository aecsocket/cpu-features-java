package cpufeatures;

import cpufeatures.aarch64.Aarch64Info;
import cpufeatures.arm.ArmInfo;
import cpufeatures.riscv.RiscvInfo;
import cpufeatures.x86.X86Info;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public final class HelloCpuFeatures {
    private static String formatInt(int value) {
        return String.format("%3d (0x%02x)", value, value);
    }

    @Test
    public void helloWorld() {
        CpuFeatures.load();

        var keys = new LinkedHashMap<String, String>();

        switch (CpuFeatures.getArchitecture()) {
            case X86 -> {
                X86Info info = CpuFeatures.getX86Info();
                keys.put("arch", "x86");
                keys.put("brand", info.brandString);
                keys.put("family", formatInt(info.family));
                keys.put("model", formatInt(info.model));
                keys.put("stepping", formatInt(info.stepping));
                keys.put("uarch", info.uarch.name());
                keys.put("flags", info.featureList().toString());
            }
            case ARM -> {
                ArmInfo info = CpuFeatures.getArmInfo();
                keys.put("arch", "ARM");
                keys.put("implementer", formatInt(info.implementer));
                keys.put("architecture", formatInt(info.architecture));
                keys.put("variant", formatInt(info.variant));
                keys.put("part", formatInt(info.part));
                keys.put("revision", formatInt(info.revision));
                keys.put("flags", info.featureList().toString());
            }
            case AARCH64 -> {
                Aarch64Info info = CpuFeatures.getAarch64Info();
                keys.put("arch", "aarch64");
                keys.put("implementer", formatInt(info.implementer));
                keys.put("variant", formatInt(info.variant));
                keys.put("part", formatInt(info.part));
                keys.put("revision", formatInt(info.revision));
                keys.put("flags", info.featureList().toString());
            }
            case RISCV -> {
                RiscvInfo info = CpuFeatures.getRiscvInfo();
                keys.put("arch", "risc-v");
                keys.put("vendor", info.vendor);
                keys.put("uarch", info.uarch);
                keys.put("flags", info.featureList().toString());
            }
            // todo not yet supported
//            case MIPS -> {
//                MipsInfo = CpuFeatures.getMipsInfo();
//                keys.put("arch", "mips");
//                keys.put("flags", info.featureList().toString());
//            }
//            case PPC -> {
//                PPCInfo info = CpuFeatures.getPPCInfo();
//                keys.put("arch", "ppc");
//            }
//            case S390X -> {
//                S390XInfo = CpuFeatures.getS390XInfo();
//                keys.put("arch", "s390x");
//            }
        }

        for (var entry : keys.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            System.out.printf("%10s: %s%n", key, value);
        }
    }
}
