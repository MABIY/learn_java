package typeinfo1;

import typeinfo1.interfacea.A;

class B1 implements A {
    @Override
    public void f() {
    }

    public void g() {
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B1();
        a.f();
        // a.g() // compile error
        System.out.println(a.getClass().getName());
        if (a instanceof B1) {
            B1 b = (B1) a;
            b.g();
        }
    }
}
