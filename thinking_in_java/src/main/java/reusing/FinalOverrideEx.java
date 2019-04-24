package reusing;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Create a class with a final method. Inherit from that class and attempt to
 * override that method.
 **/
class WithFinal2{
    final void f() {
        print("WithFinal1.f()");
    }

    void g() {
        print("WithFinal1.g()");
    }
    final void h() {
        print("WithFinal1.h()");
    }
}

class OverrideFinal extends WithFinal2 {
    // attempt to override:
    // public final void f() {
    //     print("OverrideFinal.f()"); // no can do
    // }
    @Override
    public void g() {
        print("OverrideFinal.g()"); // ok, not final
    }

    // final void h() {
    //     print("OverrideFinal.h()"); // cannot override final
    // }
}
public class FinalOverrideEx {
    public static void main(String[] args) {
        OverrideFinal of = new OverrideFinal();
        of.f();
        of.g();
        of.h();
        // Upcast:
        WithFinal2 wf = of;
        wf.f();
        wf.g();
        wf.h();
    }
}
