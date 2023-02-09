package cpufeatures.aarch64;

import cpufeatures.x86.X86Features;

import java.util.function.Predicate;

public enum Aarch64Feature {
    FP          ((x) -> x.fp),
    ASIMD       ((x) -> x.asimd),
    EVTSTRM     ((x) -> x.evtstrm),
    AES         ((x) -> x.aes),
    PMULL       ((x) -> x.pmull),
    SHA1        ((x) -> x.sha1),
    SHA2        ((x) -> x.sha2),
    CRC32       ((x) -> x.crc32),
    ATOMICS     ((x) -> x.atomics),
    FPHP        ((x) -> x.fphp),
    ASIMDHP     ((x) -> x.asimdhp),
    CPUID       ((x) -> x.cpuid),
    ASIMDRDM    ((x) -> x.asimdrdm),
    JSCVT       ((x) -> x.jscvt),
    FCMA        ((x) -> x.fcma),
    LRCPC       ((x) -> x.lrcpc),
    DCPOP       ((x) -> x.dcpop),
    SHA3        ((x) -> x.sha3),
    SM3         ((x) -> x.sm3),
    SM4         ((x) -> x.sm4),
    ASIMDDP     ((x) -> x.asimddp),
    SHA512      ((x) -> x.sha512),
    SVE         ((x) -> x.sve),
    ASIMDFHM    ((x) -> x.asimdfhm),
    DIT         ((x) -> x.dit),
    USCAT       ((x) -> x.uscat),
    ILRCPC      ((x) -> x.ilrcpc),
    FLAGM       ((x) -> x.flagm),
    SSBS        ((x) -> x.ssbs),
    SB          ((x) -> x.sb),
    PACA        ((x) -> x.paca),
    PACG        ((x) -> x.pacg),
    DCPODP      ((x) -> x.dcpodp),
    SVE2        ((x) -> x.sve2),
    SVEAES      ((x) -> x.sveaes),
    SVEPMULL    ((x) -> x.svepmull),
    SVEBITPERM  ((x) -> x.svebitperm),
    SVESHA3     ((x) -> x.svesha3),
    SVESM4      ((x) -> x.svesm4),
    FLAGM2      ((x) -> x.flagm2),
    FRINT       ((x) -> x.frint),
    SVEI8MM     ((x) -> x.svei8mm),
    SVEF32MM    ((x) -> x.svef32mm),
    SVEF64MM    ((x) -> x.svef64mm),
    SVEBF16     ((x) -> x.svebf16),
    I8MM        ((x) -> x.i8mm),
    BF16        ((x) -> x.bf16),
    DGH         ((x) -> x.dgh),
    RNG         ((x) -> x.rng),
    BTI         ((x) -> x.bti),
    MTE         ((x) -> x.mte),
    ECV         ((x) -> x.ecv),
    AFP         ((x) -> x.afp),
    RPRES       ((x) -> x.rpres);

    private final Predicate<Aarch64Features> has;

    Aarch64Feature(Predicate<Aarch64Features> has) {
        this.has = has;
    }

    public boolean has(Aarch64Features features) { return has.test(features); }
}
