package cpufeatures.x86;

import cpufeatures.headers.x86.CpuInfoX86;

import java.lang.foreign.MemorySession;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.foreign.MemoryLayout.PathElement.groupElement;

/**
 * Info on a processor running the X86 architecture.
 * @param features Which features this processor supports.
 * @param family Family.
 * @param model Model.
 * @param stepping Stepping.
 * @param vendor Manufacturer.
 * @param brandString Brand name.
 * @param uarch Microarchitecture.
 */
public record X86Info(
    X86Features features,
    int family,
    int model,
    int stepping,
    String vendor,
    String brandString,
    X86Uarch uarch
) {
    private static final VarHandle a$VH = cpufeatures.headers.x86.X86Features.$LAYOUT().varHandle(groupElement("a"));
    private static final VarHandle b$VH = cpufeatures.headers.x86.X86Features.$LAYOUT().varHandle(groupElement("b"));
    private static final VarHandle c$VH = cpufeatures.headers.x86.X86Features.$LAYOUT().varHandle(groupElement("c"));

    private static boolean get(int bits, int position) {
        return ((bits >> position) & 1) == 1;
    }

    /**
     * Gets info on the X86 processor running on this JVM.
     * <p>
     * If the host is not on an X86 processor, this operation will fail.
     * @return Processor info.
     */
    public static X86Info get() {
        try (var memory = MemorySession.openConfined()) {
            var info = CpuInfoX86.GetX86Info(memory);

            var features = cpufeatures.headers.x86.X86Info.features$slice(info);
            int a = (int) a$VH.get(features);
            int b = (int) b$VH.get(features);
            int c = (int) c$VH.get(features);
            /*
            for i in range(len(flags)):
              curfield = ["a","b","c"][int(i / 32)]
              print(f"boolean {flags[i]} = get({curfield}, {i % 32});")
             */
            boolean fpu = get(a, 0);
            boolean tsc = get(a, 1);
            boolean cx8 = get(a, 2);
            boolean clfsh = get(a, 3);
            boolean mmx = get(a, 4);
            boolean aes = get(a, 5);
            boolean erms = get(a, 6);
            boolean f16c = get(a, 7);
            boolean fma4 = get(a, 8);
            boolean fma3 = get(a, 9);
            boolean vaes = get(a, 10);
            boolean vpclmulqdq = get(a, 11);
            boolean bmi1 = get(a, 12);
            boolean hle = get(a, 13);
            boolean bmi2 = get(a, 14);
            boolean rtm = get(a, 15);
            boolean rdseed = get(a, 16);
            boolean clflushopt = get(a, 17);
            boolean clwb = get(a, 18);
            boolean sse = get(a, 19);
            boolean sse2 = get(a, 20);
            boolean sse3 = get(a, 21);
            boolean ssse3 = get(a, 22);
            boolean sse4_1 = get(a, 23);
            boolean sse4_2 = get(a, 24);
            boolean sse4a = get(a, 25);
            boolean avx = get(a, 26);
            boolean avx_vnni = get(a, 27);
            boolean avx2 = get(a, 28);
            boolean avx512f = get(a, 29);
            boolean avx512cd = get(a, 30);
            boolean avx512er = get(a, 31);
            boolean avx512pf = get(b, 0);
            boolean avx512bw = get(b, 1);
            boolean avx512dq = get(b, 2);
            boolean avx512vl = get(b, 3);
            boolean avx512ifma = get(b, 4);
            boolean avx512vbmi = get(b, 5);
            boolean avx512vbmi2 = get(b, 6);
            boolean avx512vnni = get(b, 7);
            boolean avx512bitalg = get(b, 8);
            boolean avx512vpopcntdq = get(b, 9);
            boolean avx512_4vnniw = get(b, 10);
            boolean avx512_4vbmi2 = get(b, 11);
            boolean avx512_second_fma = get(b, 12);
            boolean avx512_4fmaps = get(b, 13);
            boolean avx512_bf16 = get(b, 14);
            boolean avx512_vp2intersect = get(b, 15);
            boolean avx512_fp16 = get(b, 16);
            boolean amx_bf16 = get(b, 17);
            boolean amx_tile = get(b, 18);
            boolean amx_int8 = get(b, 19);
            boolean pclmulqdq = get(b, 20);
            boolean smx = get(b, 21);
            boolean sgx = get(b, 22);
            boolean cx16 = get(b, 23);
            boolean sha = get(b, 24);
            boolean popcnt = get(b, 25);
            boolean movbe = get(b, 26);
            boolean rdrnd = get(b, 27);
            boolean dca = get(b, 28);
            boolean ss = get(b, 29);
            boolean adx = get(b, 30);
            boolean lzcnt = get(b, 31);
            boolean gfni = get(c, 0);
            boolean movdiri = get(c, 1);
            boolean movdir64b = get(c, 2);
            boolean fs_rep_mov = get(c, 3);
            boolean fz_rep_movsb = get(c, 4);
            boolean fs_rep_stosb = get(c, 5);
            boolean fs_rep_cmpsb_scasb = get(c, 6);

            int family = cpufeatures.headers.x86.X86Info.family$get(info);
            int model = cpufeatures.headers.x86.X86Info.model$get(info);
            int stepping = cpufeatures.headers.x86.X86Info.stepping$get(info);
            String vendor = cpufeatures.headers.x86.X86Info.vendor$slice(info).getUtf8String(0);
            String brandString = cpufeatures.headers.x86.X86Info.brand_string$slice(info).getUtf8String(0);

            X86Uarch uarch = X86Uarch.values()[CpuInfoX86.GetX86Microarchitecture(info)];

            return new X86Info(
                    new X86Features(fpu, tsc, cx8, clfsh, mmx, aes, erms, f16c, fma4, fma3, vaes, vpclmulqdq, bmi1, hle, bmi2, rtm, rdseed, clflushopt, clwb, sse, sse2, sse3, ssse3, sse4_1, sse4_2, sse4a, avx, avx_vnni, avx2, avx512f, avx512cd, avx512er, avx512pf, avx512bw, avx512dq, avx512vl, avx512ifma, avx512vbmi, avx512vbmi2, avx512vnni, avx512bitalg, avx512vpopcntdq, avx512_4vnniw, avx512_4vbmi2, avx512_second_fma, avx512_4fmaps, avx512_bf16, avx512_vp2intersect, avx512_fp16, amx_bf16, amx_tile, amx_int8, pclmulqdq, smx, sgx, cx16, sha, popcnt, movbe, rdrnd, dca, ss, adx, lzcnt, gfni, movdiri, movdir64b, fs_rep_mov, fz_rep_movsb, fs_rep_stosb, fs_rep_cmpsb_scasb),
                    family,
                    model,
                    stepping,
                    vendor,
                    brandString,
                    uarch
            );
        }
    }

    /**
     * Gets a set of all features that this info holds. If you are testing for a specific feature, prefer using
     * {@link #features()} instead.
     * @return Set of features.
     */
    public Set<X86Feature> featureSet() {
        var result = new LinkedHashSet<X86Feature>();
        for (var feature : X86Feature.values()) {
            if (feature.in(features)) {
                result.add(feature);
            }
        }
        return result;
    }
}
