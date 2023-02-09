package cpufeatures.aarch64;

import cpufeatures.CpuFeatures;
import io.github.aecsocket.jniglue.JniCallback;
import io.github.aecsocket.jniglue.JniNative;
import io.github.aecsocket.jniglue.JniReferenced;

@JniNative(CpuFeatures.JNI_MODEL)
@JniReferenced
public final class Aarch64Features {
    public final boolean fp;          // Floating-point.
    public final boolean asimd;       // Advanced SIMD.
    public final boolean evtstrm;     // Generic timer generated events.
    public final boolean aes;         // Hardware-accelerated Advanced Encryption Standard.
    public final boolean pmull;       // Polynomial multiply long.
    public final boolean sha1;        // Hardware-accelerated SHA1.
    public final boolean sha2;        // Hardware-accelerated SHA2-256.
    public final boolean crc32;       // Hardware-accelerated CRC-32.
    public final boolean atomics;     // Armv8.1 atomic instructions.
    public final boolean fphp;        // Half-precision floating point support.
    public final boolean asimdhp;     // Advanced SIMD half-precision support.
    public final boolean cpuid;       // Access to certain ID registers.
    public final boolean asimdrdm;    // Rounding Double Multiply Accumulate/Subtract.
    public final boolean jscvt;       // Support for JavaScript conversion.
    public final boolean fcma;        // Floating point complex numbers.
    public final boolean lrcpc;       // Support for weaker release consistency.
    public final boolean dcpop;       // Data persistence writeback.
    public final boolean sha3;        // Hardware-accelerated SHA3.
    public final boolean sm3;         // Hardware-accelerated SM3.
    public final boolean sm4;         // Hardware-accelerated SM4.
    public final boolean asimddp;     // Dot product instruction.
    public final boolean sha512;      // Hardware-accelerated SHA512.
    public final boolean sve;         // Scalable Vector Extension.
    public final boolean asimdfhm;    // Additional half-precision instructions.
    public final boolean dit;         // Data independent timing.
    public final boolean uscat;       // Unaligned atomics support.
    public final boolean ilrcpc;      // Additional support for weaker release consistency.
    public final boolean flagm;       // Flag manipulation instructions.
    public final boolean ssbs;        // Speculative Store Bypass Safe PSTATE bit.
    public final boolean sb;          // Speculation barrier.
    public final boolean paca;        // Address authentication.
    public final boolean pacg;        // Generic authentication.
    public final boolean dcpodp;      // Data cache clean to point of persistence.
    public final boolean sve2;        // Scalable Vector Extension (version 2).
    public final boolean sveaes;      // SVE AES instructions.
    public final boolean svepmull;    // SVE polynomial multiply long instructions.
    public final boolean svebitperm;  // SVE bit permute instructions.
    public final boolean svesha3;     // SVE SHA3 instructions.
    public final boolean svesm4;      // SVE SM4 instructions.
    public final boolean flagm2;      // Additional flag manipulation instructions.
    public final boolean frint;       // Floating point to integer rounding.
    public final boolean svei8mm;     // SVE Int8 matrix multiplication instructions.
    public final boolean svef32mm;    // SVE FP32 matrix multiplication instruction.
    public final boolean svef64mm;    // SVE FP64 matrix multiplication instructions.
    public final boolean svebf16;     // SVE BFloat16 instructions.
    public final boolean i8mm;        // Int8 matrix multiplication instructions.
    public final boolean bf16;        // BFloat16 instructions.
    public final boolean dgh;         // Data Gathering Hint instruction.
    public final boolean rng;         // True random number generator support.
    public final boolean bti;         // Branch target identification.
    public final boolean mte;         // Memory tagging extension.
    public final boolean ecv;         // Enhanced counter virtualization.
    public final boolean afp;         // Alternate floating-point behaviour.
    public final boolean rpres;       // 12-bit reciprocal (square root) estimate precision.

    public Aarch64Features(boolean fp, boolean asimd, boolean evtstrm, boolean aes, boolean pmull, boolean sha1, boolean sha2, boolean crc32, boolean atomics, boolean fphp, boolean asimdhp, boolean cpuid, boolean asimdrdm, boolean jscvt, boolean fcma, boolean lrcpc, boolean dcpop, boolean sha3, boolean sm3, boolean sm4, boolean asimddp, boolean sha512, boolean sve, boolean asimdfhm, boolean dit, boolean uscat, boolean ilrcpc, boolean flagm, boolean ssbs, boolean sb, boolean paca, boolean pacg, boolean dcpodp, boolean sve2, boolean sveaes, boolean svepmull, boolean svebitperm, boolean svesha3, boolean svesm4, boolean flagm2, boolean frint, boolean svei8mm, boolean svef32mm, boolean svef64mm, boolean svebf16, boolean i8mm, boolean bf16, boolean dgh, boolean rng, boolean bti, boolean mte, boolean ecv, boolean afp, boolean rpres) {
        this.fp = fp;
        this.asimd = asimd;
        this.evtstrm = evtstrm;
        this.aes = aes;
        this.pmull = pmull;
        this.sha1 = sha1;
        this.sha2 = sha2;
        this.crc32 = crc32;
        this.atomics = atomics;
        this.fphp = fphp;
        this.asimdhp = asimdhp;
        this.cpuid = cpuid;
        this.asimdrdm = asimdrdm;
        this.jscvt = jscvt;
        this.fcma = fcma;
        this.lrcpc = lrcpc;
        this.dcpop = dcpop;
        this.sha3 = sha3;
        this.sm3 = sm3;
        this.sm4 = sm4;
        this.asimddp = asimddp;
        this.sha512 = sha512;
        this.sve = sve;
        this.asimdfhm = asimdfhm;
        this.dit = dit;
        this.uscat = uscat;
        this.ilrcpc = ilrcpc;
        this.flagm = flagm;
        this.ssbs = ssbs;
        this.sb = sb;
        this.paca = paca;
        this.pacg = pacg;
        this.dcpodp = dcpodp;
        this.sve2 = sve2;
        this.sveaes = sveaes;
        this.svepmull = svepmull;
        this.svebitperm = svebitperm;
        this.svesha3 = svesha3;
        this.svesm4 = svesm4;
        this.flagm2 = flagm2;
        this.frint = frint;
        this.svei8mm = svei8mm;
        this.svef32mm = svef32mm;
        this.svef64mm = svef64mm;
        this.svebf16 = svebf16;
        this.i8mm = i8mm;
        this.bf16 = bf16;
        this.dgh = dgh;
        this.rng = rng;
        this.bti = bti;
        this.mte = mte;
        this.ecv = ecv;
        this.afp = afp;
        this.rpres = rpres;
    }
}
