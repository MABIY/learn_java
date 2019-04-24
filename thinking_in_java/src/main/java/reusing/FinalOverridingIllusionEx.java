package reusing;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * show that the @Override annotation solves the problem in the section
 **/
class WithFinals1{
    // Identical to private alone:
    private final void f() {
        print("OverridingPrivate.f()");
    }

    // also automatically "final"
    private void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivate1 extends WithFinals1 {
    // attempt to override:
    private final void f() {
        print("OverridingPrivate1.f()");
    }

    private void g() {
        print("OverridingPrivate1.g()");
    }

    // @Override
    // private final void f() {
    //     print("OverridingPrivate1.f()");
    // }
    //
    // @Override
    // private void g() {
    //     print("OverridingPrivate.g()");
    // }
}

class OverridingPrivate12 extends OverridingPrivate1 {
    // attempt to override:
    public final void f() {
        print("OverrridingPrivate12.f()");
    }

    public void g() {
        print("OverridingPrivate12.g()");
    }
    // use @Override so compile with say "does NOT override or implement"
    // @Override
    // public final void f() {
    //     print("OVerridingPrivate12.f()");
    // }
    //
    // @Override
    // public void g() {
    //     print("OverridingPrivate12.g()");
    // }
}
public class FinalOverridingIllusionEx {
    public static void main(String[] args) {
        OverridingPrivate12 op2 = new OverridingPrivate12();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate1 op = op2;
        // op.f(); // f() has private access in OverridingPrivate1
        // op.f();
        // Same here:
        WithFinals1 wf = op2;
        // wf.f(); // f() has private access in WithFinals1
        // wf.f();
    }
}
