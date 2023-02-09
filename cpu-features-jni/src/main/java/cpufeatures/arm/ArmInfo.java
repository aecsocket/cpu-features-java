package cpufeatures.arm;

import cpufeatures.CpuFeatures;
import cpufeatures.aarch64.Aarch64Feature;
import cpufeatures.aarch64.Aarch64Features;
import io.github.aecsocket.jniglue.JniCallback;
import io.github.aecsocket.jniglue.JniNative;
import io.github.aecsocket.jniglue.JniReferenced;

import java.util.ArrayList;
import java.util.List;

@JniNative(CpuFeatures.JNI_MODEL)
@JniReferenced
public final class ArmInfo {
    public final ArmFeatures features;
    public final int implementer;
    public final int architecture;
    public final int variant;
    public final int part;
    public final int revision;

    public ArmInfo(ArmFeatures features, int implementer, int architecture, int variant, int part, int revision) {
        this.features = features;
        this.implementer = implementer;
        this.architecture = architecture;
        this.variant = variant;
        this.part = part;
        this.revision = revision;
    }
    @JniCallback
    private static ArmInfo _init(ArmFeatures features, int implementer, int architecture, int variant, int part, int revision) {
        return new ArmInfo(features, implementer, architecture, variant, part, revision);
    }

    public List<ArmFeature> featureList() {
        var result = new ArrayList<ArmFeature>();
        for (var feature : ArmFeature.values()) {
            if (feature.has(features)) {
                result.add(feature);
            }
        }
        return result;
    }
}
