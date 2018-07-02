package typeinfo1;

class Base1{}
class Derived1 extends Base1{}
public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass());
        System.out.println("x instanceof Base " + (x instanceof Base1));
        System.out.println("x instanceof Derived " + (x instanceof Derived1
        ));
        System.out.println("Base.isINstance(x) " + Base1.class.isInstance(x));
        System.out.println("Derived.isInstance(x) " + Derived1.class.isInstance(x));
        System.out.println("x.getClass() == Base.class " + (x.getClass() == Base1.class));
        System.out.println("x.getClass() == Derived.class "+ (x.getClass() == Derived1.class));
        System.out.println("x.getClass().equals(Base.class) " +(x.getClass().equals(Base1.class)));
        System.out.println("x.getClass().equals(Derived.class) " + (x.getClass().equals(Derived1.class)));
    }

    public static void main(String[] args) {
        test(new Base1());
        test(new Derived1());
    }
}
