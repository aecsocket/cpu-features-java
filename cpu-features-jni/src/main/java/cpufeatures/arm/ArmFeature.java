package cpufeatures.arm;

import cpufeatures.x86.X86Features;

import java.util.function.Predicate;

public enum ArmFeature {
    SWP         ((x) -> x.swp),
    HALF        ((x) -> x.half),
    THUMB       ((x) -> x.thumb),
    _26BIT      ((x) -> x._26bit),
    FASTMULT    ((x) -> x.fastmult),
    FPA         ((x) -> x.fpa),
    VFP         ((x) -> x.vfp),
    EDSP        ((x) -> x.edsp),
    JAVA        ((x) -> x.java),
    IWMMXT      ((x) -> x.iwmmxt),
    CRUNCH      ((x) -> x.crunch),
    THUMBEE     ((x) -> x.thumbee),
    NEON        ((x) -> x.neon),
    VFPV3       ((x) -> x.vfpv3),
    VFPV3D16    ((x) -> x.vfpv3d16),
    TLS         ((x) -> x.tls),
    VFPV4       ((x) -> x.vfpv4),
    IDIVA       ((x) -> x.idiva),
    IDIVT       ((x) -> x.idivt),
    VFPD32      ((x) -> x.vfpd32),
    LPAE        ((x) -> x.lpae),
    EVTSTRM     ((x) -> x.evtstrm),
    AES         ((x) -> x.aes),
    PMULL       ((x) -> x.pmull),
    SHA1        ((x) -> x.sha1),
    SHA2        ((x) -> x.sha2),
    CRC32       ((x) -> x.crc32);

    private final Predicate<ArmFeatures> has;

    ArmFeature(Predicate<ArmFeatures> has) {
        this.has = has;
    }

    public boolean has(ArmFeatures features) { return has.test(features); }
}
