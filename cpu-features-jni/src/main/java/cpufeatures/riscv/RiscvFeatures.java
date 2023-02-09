package cpufeatures.riscv;

import cpufeatures.CpuFeatures;
import io.github.aecsocket.jniglue.JniCallback;
import io.github.aecsocket.jniglue.JniNative;
import io.github.aecsocket.jniglue.JniReferenced;

@JniNative(CpuFeatures.JNI_MODEL)
@JniReferenced
public final class RiscvFeatures {
    // Base
    public final boolean RV32I;  // Base Integer Instruction Set, 32-bit
    public final boolean RV64I;  // Base Integer Instruction Set, 64-bit

    // Extension
    public final boolean M;         // Standard Extension for Integer Multiplication/Division
    public final boolean A;         // Standard Extension for Atomic Instructions
    public final boolean F;         // Standard Extension for Single-Precision Floating-Point
    public final boolean D;         // Standard Extension for Double-Precision Floating-Point
    public final boolean Q;         // Standard Extension for Quad-Precision Floating-Point
    public final boolean C;         // Standard Extension for Compressed Instructions
    public final boolean Zicsr;     // Control and Status Register (CSR)
    public final boolean Zifencei;  // Instruction-Fetch Fence

    @JniCallback
    public RiscvFeatures(boolean RV32I, boolean RV64I, boolean M, boolean A, boolean F, boolean D, boolean Q, boolean C, boolean Zicsr, boolean Zifencei) {
        this.RV32I = RV32I;
        this.RV64I = RV64I;
        this.M = M;
        this.A = A;
        this.F = F;
        this.D = D;
        this.Q = Q;
        this.C = C;
        this.Zicsr = Zicsr;
        this.Zifencei = Zifencei;
    }
}
