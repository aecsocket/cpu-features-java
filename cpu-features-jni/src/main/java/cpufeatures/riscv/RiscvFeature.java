package cpufeatures.riscv;

import cpufeatures.arm.ArmFeatures;

import java.util.function.Predicate;

public enum RiscvFeature {
    RV32I       ((x) -> x.RV32I),
    RV64I       ((x) -> x.RV64I),
    M           ((x) -> x.M),
    A           ((x) -> x.A),
    F           ((x) -> x.F),
    D           ((x) -> x.D),
    Q           ((x) -> x.Q),
    C           ((x) -> x.C),
    Z_ICSR      ((x) -> x.Zicsr),
    Z_IFENCEI   ((x) -> x.Zifencei);

    private final Predicate<RiscvFeatures> has;

    RiscvFeature(Predicate<RiscvFeatures> has) {
        this.has = has;
    }

    public boolean has(RiscvFeatures features) { return has.test(features); }
}
