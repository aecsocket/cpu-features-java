package cpufeatures.x86;

import cpufeatures.CpuFeatures;
import io.github.aecsocket.jniglue.JniCallback;
import io.github.aecsocket.jniglue.JniNative;
import io.github.aecsocket.jniglue.JniReferenced;

import java.util.ArrayList;
import java.util.List;

@JniNative(CpuFeatures.JNI_MODEL)
@JniReferenced
public final class X86Info {
    public final X86Features features;
    public final X86Microarchitecture microarchitecture;
    public final int family;
    public final int model;
    public final int stepping;
    public final String vendor;
    public final String brandString;

    public X86Info(X86Features features, X86Microarchitecture microarchitecture, int family, int model, int stepping, String vendor, String brandString) {
        this.features = features;
        this.microarchitecture = microarchitecture;
        this.family = family;
        this.model = model;
        this.stepping = stepping;
        this.vendor = vendor;
        this.brandString = brandString;
    }
    @JniCallback
    private static X86Info _init(X86Features features, int uarch, int family, int model, int stepping, String vendor, String brandString) {
        return new X86Info(features, X86Microarchitecture.values()[uarch], family, model, stepping, vendor, brandString);
    }

    public List<X86Feature> featureList() {
        var result = new ArrayList<X86Feature>();
        for (var feature : X86Feature.values()) {
            if (feature.has(features)) {
                result.add(feature);
            }
        }
        return result;
    }
}
