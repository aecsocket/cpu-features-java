package cpufeatures.arm;

/**
 * Feature set of a processor running the ARM architecture.
 * @param swp SWP instruction (atomic read-modify-write)
 * @param half Half-word loads and stores
 * @param thumb Thumb (16-bit instruction set)
 * @param _26bit "26 Bit" Model (Processor status register folded into program counter)
 * @param fastmult 32x32->64-bit multiplication
 * @param fpa Floating point accelerator
 * @param vfp Vector Floating Point.
 * @param edsp DSP extensions (the 'e' variant of the ARM9 CPUs, and all others above)
 * @param java Jazelle (Java bytecode accelerator)
 * @param iwmmxt Intel Wireless MMX Technology.
 * @param crunch MaverickCrunch coprocessor
 * @param thumbee ThumbEE
 * @param neon Advanced SIMD.
 * @param vfpv3 VFP version 3
 * @param vfpv3d16 VFP version 3 with 16 D-registers
 * @param tls TLS register
 * @param vfpv4 VFP version 4 with fast context switching
 * @param idiva SDIV and UDIV hardware division in ARM mode.
 * @param idivt SDIV and UDIV hardware division in Thumb mode.
 * @param vfpd32 VFP with 32 D-registers
 * @param lpae Large Physical Address Extension (>4GB physical memory on 32-bit architecture)
 * @param evtstrm kernel event stream using generic architected timer
 * @param aes Hardware-accelerated Advanced Encryption Standard.
 * @param pmull Polynomial multiply long.
 * @param sha1 Hardware-accelerated SHA1.
 * @param sha2 Hardware-accelerated SHA2-256.
 * @param crc32 Hardware-accelerated CRC-32.
 */
public record ArmFeatures(
        boolean swp,
        boolean half,
        boolean thumb,
        boolean _26bit,
        boolean fastmult,
        boolean fpa,
        boolean vfp,
        boolean edsp,
        boolean java,
        boolean iwmmxt,
        boolean crunch,
        boolean thumbee,
        boolean neon,
        boolean vfpv3,
        boolean vfpv3d16,
        boolean tls,
        boolean vfpv4,
        boolean idiva,
        boolean idivt,
        boolean vfpd32,
        boolean lpae,
        boolean evtstrm,
        boolean aes,
        boolean pmull,
        boolean sha1,
        boolean sha2,
        boolean crc32
) {}
