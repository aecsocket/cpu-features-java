package cpufeatures.arm;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Info on a processor running the ARM architecture.
 * @param features Which features this processor supports.
 * @param implementer Implementer.
 * @param architecture Architecture.
 * @param variant Variant.
 * @param part Part.
 * @param revision Revision.
 */
public record ArmInfo(
    ArmFeatures features,
    int implementer,
    int architecture,
    int variant,
    int part,
    int revision
) {
//    private static final VarHandle a$VH = cpufeatures.natives.x86.X86Features.$LAYOUT().varHandle(groupElement("a"));
//    private static final VarHandle b$VH = cpufeatures.natives.x86.X86Features.$LAYOUT().varHandle(groupElement("b"));
//    private static final VarHandle c$VH = cpufeatures.natives.x86.X86Features.$LAYOUT().varHandle(groupElement("c"));
//
//    private static boolean get(int bits, int position) {
//        return ((bits >> position) & 1) == 1;
//    }

    /**
     * Gets info on the ARM processor running on this JVM.
     * <p>
     * If the host is not on an ARM processor, this operation will fail.
     * @return Processor info.
     */
    public static ArmInfo get() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets a set of all features that this info holds. If you are testing for a specific feature, prefer using
     * {@link #features()} instead.
     * @return Set of features.
     */
    public Set<ArmFeature> featureSet() {
        var result = new LinkedHashSet<ArmFeature>();
        for (var feature : ArmFeature.values()) {
            if (feature.in(features)) {
                result.add(feature);
            }
        }
        return result;
    }
}
