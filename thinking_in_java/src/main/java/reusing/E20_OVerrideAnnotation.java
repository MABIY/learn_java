package reusing;

import static access.util.Print.print;

class OverridingPrivateE20 extends WithFinals {
    // @Override
    private final void f() {
        print("OverridingPrivateE20.f()");
    }
    // @Override
    private void g() {
        print("OveridingPrivateE20.g()");
    }
}

class OverridingPrivate2E20 extends OverridingPrivateE20 {
    // @Override
    public final void f() {
        print("OverridingPrivate2E20.f()");
    }

    // @Override
    public void g() {
        print("OverridingPrivate2E20.g()");
    }
}
public class E20_OVerrideAnnotation {
    public static void main(String[] args) {
        OverridingPrivate2E20 op2 = new OverridingPrivate2E20();
        op2.f();
        op2.g();
    }
}
