package interfaces;

import interfaces.ownpackage.AnInterface;

import static access.util.Print.print;

class ImplementInterface implements AnInterface {
    @Override
    public void f() {
        print("ImplementInterface.f");
    }

    @Override
    public void g() {
        print("ImplementInteerface.g");
    }

    @Override
    public void h() {
        print("ImplementInterface.h");
    }
}
public class E05_ImplementInterface {
    public static void main(String[] args) {
        ImplementInterface imp = new ImplementInterface();
        imp.f();
        imp.g();
        imp.h();
    }
}
