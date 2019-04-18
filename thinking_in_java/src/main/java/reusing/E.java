package reusing;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Prove that base-class constructors are(a) always called and (b) called before
 * drived-class constructors.
 **/
class A {
    public A() {
        print("A()");
    }
}

class B extends A{
    public B() {
        print("B()");
    }
}

class C extends B{
    public C() {
        print("C()");
    }
}

class D extends C {
    public D() {
        print("D()");
    }

    public static D makeD() {
        return new D();
    }

    public static void main(String[] args) {
        D d = new D();
        D d2 = makeD();
    }
}

public class E extends D {
    public E() {
        print("E()");
    }

    public static void main(String[] args) {
        E e = new E();
        // test D:
        D.main(args);
    }
}
