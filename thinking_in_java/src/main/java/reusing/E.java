package reusing;

import static org.greggordon.tools.Print.println;

class A{
    public A() {
        println("A()");
    }
}

class B extends A {
    public B() {
        println("B()");
    }
}

class C extends B{
    public C() {
        println("C()");
    }
}
class D extends C {
    public D() {
        println("D()");
    }
    public static D makeD() {
        return new D();
    }

    public static void main(String[] args) {
        D d = new D();
        D d2 = makeD();
    }
}
public class E extends D{
    public E() {
        println("E()");
    }

    public static void main(String[] args) {
        E e = new E();
        // test D:
        D.main(args);
    }
}
