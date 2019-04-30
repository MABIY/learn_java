package polymorphism;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Trying to override a private method.
 **/
public class PrivateOverride {
    private void f() {
        print("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}
