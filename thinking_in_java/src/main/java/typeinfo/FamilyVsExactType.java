package typeinfo;

import net.lh.util.Print;

import static net.lh.util.Print.print;

/**
 * @author lh
 * The difference between instanceof and class
 **/
class Base14{}
class Derived14 extends Base14{}

public class FamilyVsExactType {
    static void test(Object x) {
        print("Testing x fo type " + x.getClass());
        print("x instanceof Base " + (x instanceof Base14));
        print("x instanceof  Derived " + (x instanceof Derived14));
        print("Base14.isInstance(x) " + Base14.class.isInstance(x));
        print("Derived.isInstance(x) " + Derived14.class.isInstance(x));
        print("x.getClass() == Base14.class" + (x.getClass() == Base14.class));
        print("x.getClass() == Derived14.class" + (x.getClass() == Derived14.class));
        print("x.getClass().equals(Base14.class)" + (x.getClass()).equals(Base14.class));
        print("x.getClass().equals(Derived14.class)" + (x.getClass()).equals(Derived14.class));
    }

    public static void main(String[] args) {
        test(new Base14());
        test(new Derived14());
    }
}
