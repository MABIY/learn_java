package generics1;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder); // Call with  captured type
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);
        f2(raw); // No warnings
        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); // Waring
        f2(rawBasic); // No warning
        // upcast to Holder<?> , still figures it out:
        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
    }
}
