package generics;

/**
 * @author lh
 **/
class GenericSetter<T> { // Not self-bounded
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedG5 extends GenericSetter<Base> {
    void set(Derived derived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedG5 dgs = new DerivedG5();
        dgs.set(derived);
        dgs.set(base); // Compiles: overloaded, not overridden!
    }
}
