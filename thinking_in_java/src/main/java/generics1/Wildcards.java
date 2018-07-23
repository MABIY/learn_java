package generics1;

public class Wildcards {
    //Raw argument
    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg); //Warning:
        //Unchekced call to Set(T) as a
        // member of the raw type Holder
        holder.set(new Wildcards()); //Same warning

        //Can't do this: don't have any 'T'
        //T t = holder.get();

        // Ok ,but type information has been lost:
        Object obj = holder.get();
    }

    // Similar to rawArgs(), but errors instead of warnings:
    static void unboundedArg(Holder<?> holder, Object arg) {
        //holder.set(arg); //Error:
        // set(capture of ?) in Holder<Capture of ?>
        //cannot be applied to (Object)
        //holder.set(new Wildcards());
        //Can't do this: don't have any 'T'
        //T t = holder.get();
        // OK , but type information has been lost:
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        //holder.set(arg);//Error
        // set(capture of ? extends T) in
        // Holder<Capture of ? extends T>
        // cannot be aplied to (T)
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        //T t = holder.get();
        // find T require ? super T

        // Ok, but type information has been lost
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<>();
        long lng = 1L;

        rawArgs(raw,lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified,lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, lng);

        Long r6 = exact2(qualified, lng);
        //Long r7 = exact2(unbounded, lng);
        //Long r8 = exact2(bounded, lng);
        Long r9 = wildSubtype(raw, lng);

        Long r10 = wildSubtype(qualified, lng);
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);
        wildSupertype(raw, lng);
        wildSupertype(qualified, lng);
    }
}
