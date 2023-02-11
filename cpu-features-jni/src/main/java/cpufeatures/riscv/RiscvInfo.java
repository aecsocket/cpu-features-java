package cpufeatures.riscv;

import cpufeatures.CpuFeatures;
import cpufeatures.arm.ArmFeature;
import cpufeatures.arm.ArmFeatures;
import io.github.aecsocket.jniglue.JniCallback;
import io.github.aecsocket.jniglue.JniNative;
import io.github.aecsocket.jniglue.JniReferenced;

import java.util.ArrayList;
import java.util.List;

@JniNative(CpuFeatures.JNI_MODEL)
@JniReferenced
public final class RiscvInfo {
    public final RiscvFeatures features;
    public final String uarch;
    public final String vendor;

    public RiscvInfo(RiscvFeatures features, String uarch, String vendor) {
        this.features = features;
        this.uarch = uarch;
        this.vendor = vendor;
    }
    @JniCallback
    private static RiscvInfo _init(RiscvFeatures features, String uarch, String vendor) {
        return new RiscvInfo(features, uarch, vendor);
    }

    public List<RiscvFeature> featureList() {
        var result = new ArrayList<RiscvFeature>();
        for (var feature : RiscvFeature.values()) {
            if (feature.has(features)) {
                result.add(feature);
            }
        }
        return result;
    }

    public boolean has(RiscvFeature feature) {
        return feature.has(features);
    }
}
