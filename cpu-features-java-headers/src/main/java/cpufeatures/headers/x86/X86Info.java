// Generated by jextract

package cpufeatures.headers.x86;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

import static java.lang.foreign.ValueLayout.PathElement;
public class X86Info {

    static final  GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
        // cpu-features-java
        MemoryLayout.structLayout(
            Constants$root.C_INT$LAYOUT.withName("a"),
            Constants$root.C_INT$LAYOUT.withName("b"),
            Constants$root.C_INT$LAYOUT.withName("c")
        ).withName("features"),
        Constants$root.C_INT$LAYOUT.withName("family"),
        Constants$root.C_INT$LAYOUT.withName("model"),
        Constants$root.C_INT$LAYOUT.withName("stepping"),
        MemoryLayout.sequenceLayout(13, Constants$root.C_CHAR$LAYOUT).withName("vendor"),
        MemoryLayout.sequenceLayout(49, Constants$root.C_CHAR$LAYOUT).withName("brand_string"),
        MemoryLayout.paddingLayout(16)
    );
    public static MemoryLayout $LAYOUT() {
        return X86Info.$struct$LAYOUT;
    }
    public static MemorySegment features$slice(MemorySegment seg) {
        return seg.asSlice(0, 12);
    }
    static final VarHandle family$VH = $struct$LAYOUT.varHandle(PathElement.groupElement("family"));
    public static VarHandle family$VH() {
        return X86Info.family$VH;
    }
    public static int family$get(MemorySegment seg) {
        return (int)X86Info.family$VH.get(seg);
    }
    public static void family$set( MemorySegment seg, int x) {
        X86Info.family$VH.set(seg, x);
    }
    public static int family$get(MemorySegment seg, long index) {
        return (int)X86Info.family$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void family$set(MemorySegment seg, long index, int x) {
        X86Info.family$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle model$VH = $struct$LAYOUT.varHandle(PathElement.groupElement("model"));
    public static VarHandle model$VH() {
        return X86Info.model$VH;
    }
    public static int model$get(MemorySegment seg) {
        return (int)X86Info.model$VH.get(seg);
    }
    public static void model$set( MemorySegment seg, int x) {
        X86Info.model$VH.set(seg, x);
    }
    public static int model$get(MemorySegment seg, long index) {
        return (int)X86Info.model$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void model$set(MemorySegment seg, long index, int x) {
        X86Info.model$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle stepping$VH = $struct$LAYOUT.varHandle(PathElement.groupElement("stepping"));
    public static VarHandle stepping$VH() {
        return X86Info.stepping$VH;
    }
    public static int stepping$get(MemorySegment seg) {
        return (int)X86Info.stepping$VH.get(seg);
    }
    public static void stepping$set( MemorySegment seg, int x) {
        X86Info.stepping$VH.set(seg, x);
    }
    public static int stepping$get(MemorySegment seg, long index) {
        return (int)X86Info.stepping$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void stepping$set(MemorySegment seg, long index, int x) {
        X86Info.stepping$VH.set(seg.asSlice(index*sizeof()), x);
    }
    public static MemorySegment vendor$slice(MemorySegment seg) {
        return seg.asSlice(24, 13);
    }
    public static MemorySegment brand_string$slice(MemorySegment seg) {
        return seg.asSlice(37, 49);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemoryAddress addr, MemorySession session) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session); }
}

