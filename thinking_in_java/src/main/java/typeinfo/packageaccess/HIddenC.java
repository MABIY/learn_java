package typeinfo.packageaccess;

import typeinfo.interfacea.A;

import static net.lh.util.Print.print;

/**
 * @author lh
 **/
class C implements A {
    @Override
    public void f() {
        print("public C.f()");
    }

    public void g() {
        print("public C.g()");
    }
    void u() {
        print("package C.u()");
    }

    protected void v() {
        print("protected C.v()");
    }

    private void w() {
        print("private C.w()");
    }
}
public class HIddenC {
    public static A makeA() {
        return new C();
    }
}
