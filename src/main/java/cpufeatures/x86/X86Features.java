package cpufeatures.x86;

/**
 * Feature set of a processor running the ARM architecture.
 * @param fpu
 * @param tsc
 * @param cx8
 * @param clfsh
 * @param mmx
 * @param aes
 * @param erms
 * @param f16c
 * @param fma4
 * @param fma3
 * @param vaes
 * @param vpclmulqdq
 * @param bmi1
 * @param hle
 * @param bmi2
 * @param rtm
 * @param rdseed
 * @param clflushopt
 * @param clwb
 * @param sse
 * @param sse2
 * @param sse3
 * @param ssse3
 * @param sse4_1
 * @param sse4_2
 * @param sse4a
 * @param avx
 * @param avx_vnni
 * @param avx2
 * @param avx512f
 * @param avx512cd
 * @param avx512er
 * @param avx512pf
 * @param avx512bw
 * @param avx512dq
 * @param avx512vl
 * @param avx512ifma
 * @param avx512vbmi
 * @param avx512vbmi2
 * @param avx512vnni
 * @param avx512bitalg
 * @param avx512vpopcntdq
 * @param avx512_4vnniw
 * @param avx512_4vbmi2
 * @param avx512_second_fma
 * @param avx512_4fmaps
 * @param avx512_bf16
 * @param avx512_vp2intersect
 * @param avx512_fp16
 * @param amx_bf16
 * @param amx_tile
 * @param amx_int8
 * @param pclmulqdq
 * @param smx
 * @param sgx
 * @param cx16
 * @param sha
 * @param popcnt
 * @param movbe
 * @param rdrnd
 * @param dca
 * @param ss
 * @param adx
 * @param lzcnt
 * @param gfni
 * @param movdiri
 * @param movdir64b
 * @param fs_rep_mov
 * @param fz_rep_movsb
 * @param fs_rep_stosb
 * @param fs_rep_cmpsb_scasb
 */
public record X86Features(
        boolean fpu,
        boolean tsc,
        boolean cx8,
        boolean clfsh,
        boolean mmx,
        boolean aes,
        boolean erms,
        boolean f16c,
        boolean fma4,
        boolean fma3,
        boolean vaes,
        boolean vpclmulqdq,
        boolean bmi1,
        boolean hle,
        boolean bmi2,
        boolean rtm,
        boolean rdseed,
        boolean clflushopt,
        boolean clwb,
        boolean sse,
        boolean sse2,
        boolean sse3,
        boolean ssse3,
        boolean sse4_1,
        boolean sse4_2,
        boolean sse4a,
        boolean avx,
        boolean avx_vnni,
        boolean avx2,
        boolean avx512f,
        boolean avx512cd,
        boolean avx512er,
        boolean avx512pf,
        boolean avx512bw,
        boolean avx512dq,
        boolean avx512vl,
        boolean avx512ifma,
        boolean avx512vbmi,
        boolean avx512vbmi2,
        boolean avx512vnni,
        boolean avx512bitalg,
        boolean avx512vpopcntdq,
        boolean avx512_4vnniw,
        boolean avx512_4vbmi2,
        boolean avx512_second_fma,
        boolean avx512_4fmaps,
        boolean avx512_bf16,
        boolean avx512_vp2intersect,
        boolean avx512_fp16,
        boolean amx_bf16,
        boolean amx_tile,
        boolean amx_int8,
        boolean pclmulqdq,
        boolean smx,
        boolean sgx,
        boolean cx16,
        boolean sha,
        boolean popcnt,
        boolean movbe,
        boolean rdrnd,
        boolean dca,
        boolean ss,
        boolean adx,
        boolean lzcnt,
        boolean gfni,
        boolean movdiri,
        boolean movdir64b,
        boolean fs_rep_mov,
        boolean fz_rep_movsb,
        boolean fs_rep_stosb,
        boolean fs_rep_cmpsb_scasb
) {}
