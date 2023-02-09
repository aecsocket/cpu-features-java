package cpufeatures.aarch64;

import cpufeatures.CpuFeatures;
import cpufeatures.x86.X86Feature;
import cpufeatures.x86.X86Features;
import cpufeatures.x86.X86Microarchitecture;
import io.github.aecsocket.jniglue.JniCallback;
import io.github.aecsocket.jniglue.JniNative;
import io.github.aecsocket.jniglue.JniReferenced;

import java.util.ArrayList;
import java.util.List;

@JniNative(CpuFeatures.JNI_MODEL)
@JniReferenced
public final class Aarch64Info {
    public final Aarch64Features features;
    public final int implementer;
    public final int variant;
    public final int part;
    public final int revision;

    public Aarch64Info(Aarch64Features features, int implementer, int variant, int part, int revision) {
        this.features = features;
        this.implementer = implementer;
        this.variant = variant;
        this.part = part;
        this.revision = revision;
    }
    @JniCallback
    private static Aarch64Info _init(Aarch64Features features, int implementer, int variant, int part, int revision) {
        return new Aarch64Info(features, implementer, variant, part, revision);
    }

    public List<Aarch64Feature> featureList() {
        var result = new ArrayList<Aarch64Feature>();
        for (var feature : Aarch64Feature.values()) {
            if (feature.has(features)) {
                result.add(feature);
            }
        }
        return result;
    }
}
