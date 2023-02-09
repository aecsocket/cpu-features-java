package cpufeatures;

import cpufeatures.aarch64.Aarch64Info;
import cpufeatures.arm.ArmInfo;
import cpufeatures.riscv.RiscvInfo;
import cpufeatures.x86.X86Info;
import io.github.aecsocket.jniglue.*;

@JniNative(CpuFeatures.JNI_MODEL)
@JniInclude("<cpuinfo_x86.h>")
@JniHeader("""
        #include <cpu_features_macros.h>
        
        #if defined(CPU_FEATURES_ARCH_AARCH64)
        #include <cpuinfo_aarch64.h>
        #endif
        #if defined(CPU_FEATURES_ARCH_ARM)
        #include <cpuinfo_arm.h>
        #endif
        #if defined(CPU_FEATURES_ARCH_RISCV)
        #include <cpuinfo_riscv.h>
        #endif
        #if defined(CPU_FEATURES_ARCH_X86)
        #include <cpuinfo_x86.h>
        #endif
        
        jclass jni_IllegalStateException;
        
        #define WRONG_ARCH { \
            env->ThrowNew(jni_IllegalStateException, "Wrong architecture for this method"); \
            return nullptr; \
        }
        
        using namespace cpu_features;""")
@JniOnLoad("""
        jni_IllegalStateException = env->FindClass("java/lang/IllegalStateException");
        if (env->ExceptionCheck()) return JNI_ERR;""")
public final class CpuFeatures {
    public static final String JNI_MODEL = "cpufeatures/CpuFeaturesJNI";

    public static void load() {
        // TODO properly
        String file = System.getProperty("user.dir") + "/../cpu-features-jni-bindings/build/lib/main/debug/libcpu-features-jni-bindings.so";
        System.load(file);
    }

    public static CpuArchitecture getArchitecture() { return CpuArchitecture.values()[_getArchitecture()]; }
    @JniBind("""
            #if defined(CPU_FEATURES_ARCH_AARCH64)
            return 0;
            #elif defined(CPU_FEATURES_ARCH_ARM)
            return 1;
            #elif defined(CPU_FEATURES_ARCH_MIPS)
            return 2;
            #elif defined(CPU_FEATURES_ARCH_PPC)
            return 3;
            #elif defined(CPU_FEATURES_ARCH_RICSV)
            return 4;
            #elif defined(CPU_FEATURES_ARCH_S390X)
            return 5;
            #elif defined(CPU_FEATURES_ARCH_X86)
            return 6;
            #endif""")
    private static native int _getArchitecture();

    public static Aarch64Info getAarch64Info() { return _getAarch64Info(); }
    @JniBind("""
            #if defined(CPU_FEATURES_ARCH_AARCH64)
            Aarch64Info info = GetAarch64Info();
            jobject features = JNI_Aarch64Features__init(env,
                info.features.fp, info.features.asimd, info.features.evtstrm, info.features.aes, info.features.pmull, info.features.sha1, info.features.sha2, info.features.crc32, info.features.atomics, info.features.fphp, info.features.asimdhp, info.features.cpuid, info.features.asimdrdm, info.features.jscvt, info.features.fcma, info.features.lrcpc, info.features.dcpop, info.features.sha3, info.features.sm3, info.features.sm4, info.features.asimddp, info.features.sha512, info.features.sve, info.features.asimdfhm, info.features.dit, info.features.uscat, info.features.ilrcpc, info.features.flagm, info.features.ssbs, info.features.sb, info.features.paca, info.features.pacg, info.features.dcpodp, info.features.sve2, info.features.sveaes, info.features.svepmull, info.features.svebitperm, info.features.svesha3, info.features.svesm4, info.features.flagm2, info.features.frint, info.features.svei8mm, info.features.svef32mm, info.features.svef64mm, info.features.svebf16, info.features.i8mm, info.features.bf16, info.features.dgh, info.features.rng, info.features.bti, info.features.mte, info.features.ecv, info.features.afp, info.features.rpres);
            return JNI_Aarch64Info_init(env, features, info.implementer, info.variant, info.part, info.revision);
            #else
            WRONG_ARCH
            #endif""")
    private static native Aarch64Info _getAarch64Info();

    public static ArmInfo getArmInfo() { return _getArmInfo(); }
    @JniBind("""
            #if defined(CPU_FEATURES_ARCH_ARM)
            ArmInfo info = GetArmInfo();
            jobject features = JNI_ArmFeatures__init(env,
                info.features.swp, info.features.half, info.features.thumb, info.features._26bit, info.features.fastmult, info.features.fpa, info.features.vfp, info.features.edsp, info.features.java, info.features.iwmmxt, info.features.crunch, info.features.thumbee, info.features.neon, info.features.vfpv3, info.features.vfpv3d16, info.features.tls, info.features.vfpv4, info.features.idiva, info.features.idivt, info.features.vfpd32, info.features.lpae, info.features.evtstrm, info.features.aes, info.features.pmull, info.features.sha1, info.features.sha2, info.features.crc32);
            return JNI_ArmInfo_init(env, features, info.implementer, info.architecture, info.variant, info.part, info.revision);
            #else
            WRONG_ARCH
            #endif""")
    private static native ArmInfo _getArmInfo();

    public static RiscvInfo getRiscvInfo() { return _getRiscvInfo(); }
    @JniBind("""
            #if defined(CPU_FEATURES_ARCH_RISCV)
            RiscvInfo info = GetRiscvInfo();
            jobject features = JNI_RiscvFeatures__init(env,
                info.features.RV32I, info.features.RV64I, info.features.M, info.features.A, info.features.F, info.features.D, info.features.Q, info.features.C, info.features.Zicsr, info.features.Zifencei);
            jstring uarch = env->NewStringUTF(info.uarch);
            jstring vendor = env->NewStringUTF(info.vendor);
            return JNI_RiscvInfo_init(env, features, uarch, vendor);
            #else
            WRONG_ARCH
            #endif""")
    private static native RiscvInfo _getRiscvInfo();

    public static X86Info getX86Info() { return _getX86Info(); }
    @JniBind("""
            #if defined(CPU_FEATURES_ARCH_X86)
            X86Info info = GetX86Info();
            jobject features = JNI_X86Features__init(env, info.features.fpu, info.features.tsc, info.features.cx8, info.features.clfsh, info.features.mmx, info.features.aes, info.features.erms, info.features.f16c, info.features.fma4, info.features.fma3, info.features.vaes, info.features.vpclmulqdq, info.features.bmi1, info.features.hle, info.features.bmi2, info.features.rtm, info.features.rdseed, info.features.clflushopt, info.features.clwb, info.features.sse, info.features.sse2, info.features.sse3, info.features.ssse3, info.features.sse4_1, info.features.sse4_2, info.features.sse4a, info.features.avx, info.features.avx_vnni, info.features.avx2, info.features.avx512f, info.features.avx512cd, info.features.avx512er, info.features.avx512pf, info.features.avx512bw, info.features.avx512dq, info.features.avx512vl, info.features.avx512ifma, info.features.avx512vbmi, info.features.avx512vbmi2, info.features.avx512vnni, info.features.avx512bitalg, info.features.avx512vpopcntdq, info.features.avx512_4vnniw, info.features.avx512_4vbmi2, info.features.avx512_second_fma, info.features.avx512_4fmaps, info.features.avx512_bf16, info.features.avx512_vp2intersect, info.features.avx512_fp16, info.features.amx_bf16, info.features.amx_tile, info.features.amx_int8, info.features.pclmulqdq, info.features.smx, info.features.sgx, info.features.cx16, info.features.sha, info.features.popcnt, info.features.movbe, info.features.rdrnd, info.features.dca, info.features.ss, info.features.adx, info.features.lzcnt, info.features.gfni, info.features.movdiri, info.features.movdir64b, info.features.fs_rep_mov, info.features.fz_rep_movsb, info.features.fs_rep_stosb, info.features.fs_rep_cmpsb_scasb);
            jint uarch = GetX86Microarchitecture(&info);
            jstring vendor = env->NewStringUTF(info.vendor);
            jstring brandString = env->NewStringUTF(info.brand_string);
            // TODO if the class isn't re-found, the call crashes. WTF???
            jni_X86Info = env->FindClass("cpufeatures/x86/X86Info");
            return JNI_X86Info_init(env, features, uarch, info.family, info.model, info.stepping, vendor, brandString);
            #else
            WRONG_ARCH
            #endif""")
    private static native X86Info _getX86Info();
}
