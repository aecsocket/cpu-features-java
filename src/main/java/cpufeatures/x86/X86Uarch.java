package cpufeatures.x86;

/**
 * Microarchitecture of an X86 processor.
 */
public enum X86Uarch {
    /** Unknown architecture */
    X86_UNKNOWN,
    /** ZhangJiang */
    ZHAOXIN_ZHANGJIANG,
    /** WuDaoKou */
    ZHAOXIN_WUDAOKOU,
    /** LuJiaZui */
    ZHAOXIN_LUJIAZUI,
    /** YongFeng */
    ZHAOXIN_YONGFENG,
    /** 80486 */
    INTEL_80486,
    /** P5 */
    INTEL_P5,
    /** Lakemont */
    INTEL_LAKEMONT,
    /** Core */
    INTEL_CORE,
    /** Penryn */
    INTEL_PNR,
    /** Nehalem */
    INTEL_NHM,
    /** Bonnell */
    INTEL_ATOM_BNL,
    /** Westmere */
    INTEL_WSM,
    /** Sandy Bridge */
    INTEL_SNB,
    /** Ivy Bridge */
    INTEL_IVB,
    /** Silvermont */
    INTEL_ATOM_SMT,
    /** Haswell */
    INTEL_HSW,
    /** Broadwell */
    INTEL_BDW,
    /** Skylake */
    INTEL_SKL,
    /** Cascade Lake */
    INTEL_CCL,
    /** Goldmont */
    INTEL_ATOM_GMT,
    /** Goldmont+ */
    INTEL_ATOM_GMT_PLUS,
    /** Tremont */
    INTEL_ATOM_TMT,
    /** Kaby Lake */
    INTEL_KBL,
    /** Coffee Lake */
    INTEL_CFL,
    /** Whiskey Lake */
    INTEL_WHL,
    /** Comet Lake */
    INTEL_CML,
    /** Cannon Lake */
    INTEL_CNL,
    /** Ice Lake */
    INTEL_ICL,
    /** Tiger Lake */
    INTEL_TGL,
    /** Sapphire Rapids */
    INTEL_SPR,
    /** Alder Lake */
    INTEL_ADL,
    /** Rocket Lake */
    INTEL_RCL,
    /** Raptor Lake */
    INTEL_RPL,
    /** Knights Mill */
    INTEL_KNIGHTS_M,
    /** Knights Landing */
    INTEL_KNIGHTS_L,
    /** Knights Ferry */
    INTEL_KNIGHTS_F,
    /** Knights Corner */
    INTEL_KNIGHTS_C,
    /** Netburst */
    INTEL_NETBURST,
    /** K8 Hammer */
    AMD_HAMMER,
    /** K10 */
    AMD_K10,
    /** K11 */
    AMD_K11,
    /** K12 Llano */
    AMD_K12,
    /** K14 Bobcat */
    AMD_BOBCAT,
    /** K15 Piledriver */
    AMD_PILEDRIVER,
    /** K15 Steamroller */
    AMD_STREAMROLLER,
    /** K15 Excavator */
    AMD_EXCAVATOR,
    /** K15 Bulldozer */
    AMD_BULLDOZER,
    /** K16 Jaguar */
    AMD_JAGUAR,
    /** K16 Puma */
    AMD_PUMA,
    /** K17 Zen */
    AMD_ZEN,
    /** K17 Zen+ */
    AMD_ZEN_PLUS,
    /** K17 Zen 2 */
    AMD_ZEN2,
    /** K19 Zen 3 */
    AMD_ZEN3,
    /** K19 Zen 4 */
    AMD_ZEN4
}
