package cpufeatures.arm;

import java.util.function.Predicate;

/**
 * Feature that can be present on an ARM processor.
 */
public enum ArmFeature {
    /** SWP instruction (atomic read-modify-write) */
    SWP         (ArmFeatures::swp),
    /** Half-word loads and stores */
    HALF        (ArmFeatures::half),
    /** Thumb (16-bit instruction set) */
    THUMB       (ArmFeatures::thumb),
    /** "26 Bit" Model (Processor status register folded into program counter) */
    _26BIT      (ArmFeatures::_26bit),
    /** 32x32->64-bit multiplication */
    FASTMULT    (ArmFeatures::fastmult),
    /** Floating point accelerator */
    FPA         (ArmFeatures::fpa),
    /** Vector Floating Point */
    VFP         (ArmFeatures::vfp),
    /** DSP extensions (the 'e' variant of the ARM9 CPUs, and all others above) */
    EDSP        (ArmFeatures::edsp),
    /** Jazelle (Java bytecode accelerator) */
    JAVA        (ArmFeatures::java),
    /** Intel Wireless MMX Technology */
    IWMMXT      (ArmFeatures::iwmmxt),
    /** MaverickCrunch coprocessor */
    CRUNCH      (ArmFeatures::crunch),
    /** ThumbEE */
    THUMBEE     (ArmFeatures::thumbee),
    /** Advanced SIMD */
    NEON        (ArmFeatures::neon),
    /** VFP version 3 */
    VFPV3       (ArmFeatures::vfpv3),
    /** VFP version 3 with 16 D-registers */
    VFPV3D16    (ArmFeatures::vfpv3d16),
    /** TLS register */
    TLS         (ArmFeatures::tls),
    /** VFP version 4 with fast context switching */
    VFPV4       (ArmFeatures::vfpv4),
    /** SDIV and UDIV hardware division in ARM mode */
    IDIVA       (ArmFeatures::idiva),
    /** SDIV and UDIV hardware division in Thumb mode */
    IDIVT       (ArmFeatures::idivt),
    /** VFP with 32 D-registers */
    VFPD32      (ArmFeatures::vfpd32),
    /** VFP with 32 D-registersLarge Physical Address Extension (>4GB physical memory on 32-bit architecture) */
    LPAE        (ArmFeatures::lpae),
    /** Kernel event stream using generic architected timer */
    EVTSTRM     (ArmFeatures::evtstrm),
    /** Hardware-accelerated Advanced Encryption Standard */
    AES         (ArmFeatures::aes),
    /** Polynomial multiply long */
    PMULL       (ArmFeatures::pmull),
    /** Hardware-accelerated SHA1 */
    SHA1        (ArmFeatures::sha1),
    /** Hardware-accelerated SHA2-256 */
    SHA2        (ArmFeatures::sha2),
    /** Hardware-accelerated CRC-32 */
    CRC32       (ArmFeatures::crc32);

    private final Predicate<ArmFeatures> predicate;

    ArmFeature(Predicate<ArmFeatures> predicate) {
        this.predicate = predicate;
    }

    /**
     * Gets if this feature is present in a features object.
     * @param features Features object.
     * @return Present state.
     */
    public boolean in(ArmFeatures features) { return predicate.test(features); }
}
