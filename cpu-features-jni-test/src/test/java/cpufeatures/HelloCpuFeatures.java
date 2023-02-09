package cpufeatures;

import cpufeatures.aarch64.Aarch64Info;
import cpufeatures.x86.X86Info;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

public final class HelloCpuFeatures {
    @Test
    public void helloWorld() {
        CpuFeatures.load();

        X86Info info = CpuFeatures.getX86Info();
        System.out.println("arch            : x86");
        System.out.printf ("brand           : %s%n", info.brandString);
        System.out.printf ("family          : %3d (0x%02x)%n", info.family, info.family);
        System.out.printf ("model           : %3d (0x%02x)%n", info.model, info.model);
        System.out.printf ("stepping        : %3d (0x%02x)%n", info.stepping, info.stepping);
        System.out.printf ("uarch           : %s%n", info.microarchitecture);
        System.out.printf ("flags           : %s%n", info.featureList());
    }
}
