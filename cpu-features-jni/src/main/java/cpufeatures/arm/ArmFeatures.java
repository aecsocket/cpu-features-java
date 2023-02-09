package cpufeatures.arm;

import cpufeatures.CpuFeatures;
import io.github.aecsocket.jniglue.JniCallback;
import io.github.aecsocket.jniglue.JniNative;
import io.github.aecsocket.jniglue.JniReferenced;

@JniNative(CpuFeatures.JNI_MODEL)
@JniReferenced
public final class ArmFeatures {
    public final boolean swp;      // SWP instruction (atomic read-modify-write)
    public final boolean half;     // Half-word loads and stores
    public final boolean thumb;    // Thumb (16-bit instruction set)
    public final boolean _26bit;   // "26 Bit" Model (Processor status register folded into program counter)
    public final boolean fastmult; // 32x32->64-bit multiplication
    public final boolean fpa;      // Floating point accelerator
    public final boolean vfp;      // Vector Floating Point.
    public final boolean edsp;     // DSP extensions (the 'e' variant of the ARM9 CPUs, and all others above)
    public final boolean java;     // Jazelle (Java bytecode accelerator)
    public final boolean iwmmxt;   // Intel Wireless MMX Technology.
    public final boolean crunch;   // MaverickCrunch coprocessor
    public final boolean thumbee;  // ThumbEE
    public final boolean neon;     // Advanced SIMD.
    public final boolean vfpv3;    // VFP version 3
    public final boolean vfpv3d16; // VFP version 3 with 16 D-registers
    public final boolean tls;      // TLS register
    public final boolean vfpv4;    // VFP version 4 with fast context switching
    public final boolean idiva;    // SDIV and UDIV hardware division in ARM mode.
    public final boolean idivt;    // SDIV and UDIV hardware division in Thumb mode.
    public final boolean vfpd32;   // VFP with 32 D-registers
    public final boolean lpae;     // Large Physical Address Extension (>4GB physical memory on 32-bit architecture)
    public final boolean evtstrm;  // kernel event stream using generic architected timer
    public final boolean aes;      // Hardware-accelerated Advanced Encryption Standard.
    public final boolean pmull;    // Polynomial multiply long.
    public final boolean sha1;     // Hardware-accelerated SHA1.
    public final boolean sha2;     // Hardware-accelerated SHA2-256.
    public final boolean crc32;    // Hardware-accelerated CRC-32.

    @JniCallback
    public ArmFeatures(boolean swp, boolean half, boolean thumb, boolean _26bit, boolean fastmult, boolean fpa, boolean vfp, boolean edsp, boolean java, boolean iwmmxt, boolean crunch, boolean thumbee, boolean neon, boolean vfpv3, boolean vfpv3d16, boolean tls, boolean vfpv4, boolean idiva, boolean idivt, boolean vfpd32, boolean lpae, boolean evtstrm, boolean aes, boolean pmull, boolean sha1, boolean sha2, boolean crc32) {
        this.swp = swp;
        this.half = half;
        this.thumb = thumb;
        this._26bit = _26bit;
        this.fastmult = fastmult;
        this.fpa = fpa;
        this.vfp = vfp;
        this.edsp = edsp;
        this.java = java;
        this.iwmmxt = iwmmxt;
        this.crunch = crunch;
        this.thumbee = thumbee;
        this.neon = neon;
        this.vfpv3 = vfpv3;
        this.vfpv3d16 = vfpv3d16;
        this.tls = tls;
        this.vfpv4 = vfpv4;
        this.idiva = idiva;
        this.idivt = idivt;
        this.vfpd32 = vfpd32;
        this.lpae = lpae;
        this.evtstrm = evtstrm;
        this.aes = aes;
        this.pmull = pmull;
        this.sha1 = sha1;
        this.sha2 = sha2;
        this.crc32 = crc32;
    }
}
