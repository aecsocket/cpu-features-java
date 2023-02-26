package cpufeatures.x86;

import java.util.function.Predicate;

/**
 * Feature that can be present on an X86 processor.
 */
public enum X86Feature {
    FPU                 (X86Features::fpu),
    TSC                 (X86Features::tsc),
    CX8                 (X86Features::cx8),
    CLFSH               (X86Features::clfsh),
    MMX                 (X86Features::mmx),
    AES                 (X86Features::aes),
    ERMS                (X86Features::erms),
    F16C                (X86Features::f16c),
    FMA4                (X86Features::fma4),
    FMA3                (X86Features::fma3),
    VAES                (X86Features::vaes),
    VPCLMULQDQ          (X86Features::vpclmulqdq),
    BMI1                (X86Features::bmi1),
    HLE                 (X86Features::hle),
    BMI2                (X86Features::bmi2),
    RTM                 (X86Features::rtm),
    RDSEED              (X86Features::rdseed),
    CLFLUSHOPT          (X86Features::clflushopt),
    CLWB                (X86Features::clwb),
    SSE                 (X86Features::sse),
    SSE2                (X86Features::sse2),
    SSE3                (X86Features::sse3),
    SSSE3               (X86Features::ssse3),
    SSE4_1              (X86Features::sse4_1),
    SSE4_2              (X86Features::sse4_2),
    SSE4A               (X86Features::sse4a),
    AVX                 (X86Features::avx),
    AVX_VNNI            (X86Features::avx_vnni),
    AVX2                (X86Features::avx2),
    AVX512F             (X86Features::avx512f),
    AVX512CD            (X86Features::avx512cd),
    AVX512ER            (X86Features::avx512er),
    AVX512PF            (X86Features::avx512pf),
    AVX512BW            (X86Features::avx512bw),
    AVX512DQ            (X86Features::avx512dq),
    AVX512VL            (X86Features::avx512vl),
    AVX512IFMA          (X86Features::avx512ifma),
    AVX512VBMI          (X86Features::avx512vbmi),
    AVX512VBMI2         (X86Features::avx512vbmi2),
    AVX512VNNI          (X86Features::avx512vnni),
    AVX512BITALG        (X86Features::avx512bitalg),
    AVX512VPOPCNTDQ     (X86Features::avx512vpopcntdq),
    AVX512_4VNNIW       (X86Features::avx512_4vnniw),
    AVX512_4VBMI2       (X86Features::avx512_4vbmi2),
    AVX512_SECOND_FMA   (X86Features::avx512_second_fma),
    AVX512_4FMAPS       (X86Features::avx512_4fmaps),
    AVX512_BF16         (X86Features::avx512_bf16),
    AVX512_VP2INTERSECT (X86Features::avx512_vp2intersect),
    AVX512_FP16         (X86Features::avx512_fp16),
    AMX_BF16            (X86Features::amx_bf16),
    AMX_TILE            (X86Features::amx_tile),
    AMX_INT8            (X86Features::amx_int8),
    PCLMULQDQ           (X86Features::pclmulqdq),
    SMX                 (X86Features::smx),
    SGX                 (X86Features::sgx),
    CX16                (X86Features::cx16),
    SHA                 (X86Features::sha),
    POPCNT              (X86Features::popcnt),
    MOVBE               (X86Features::movbe),
    RDRND               (X86Features::rdrnd),
    DCA                 (X86Features::dca),
    SS                  (X86Features::ss),
    ADX                 (X86Features::adx),
    LZCNT               (X86Features::lzcnt),
    GFNI                (X86Features::gfni),
    MOVDIRI             (X86Features::movdiri),
    MOVDIR64B           (X86Features::movdir64b),
    FS_REP_MOV          (X86Features::fs_rep_mov),
    FZ_REP_MOVSB        (X86Features::fz_rep_movsb),
    FS_REP_STOSB        (X86Features::fs_rep_stosb),
    FS_REP_CMPSB_SCASB  (X86Features::fs_rep_cmpsb_scasb);

    private final Predicate<X86Features> predicate;

    X86Feature(Predicate<X86Features> predicate) {
        this.predicate = predicate;
    }

    /**
     * Gets if this feature is present in a features object.
     * @param features Features object.
     * @return Present state.
     */
    public boolean in(X86Features features) { return predicate.test(features); }
}
