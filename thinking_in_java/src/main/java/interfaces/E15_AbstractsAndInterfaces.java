package interfaces;

import static access.util.Print.print;

abstract class Abstract{
    String s;

    public Abstract(String s) {
        this.s = s;
    }

    abstract void af();
}

class All2 extends Abstract implements Multiple {
    public All2() {
        super("All2");
    }

    @Override
    void af() {
        print("All.af");
    }

    @Override
    public void f1() {
        print("All.f1");
    }

    @Override
    public void g1() {
        print("All.g1");
    }

    @Override
    public void f2() {
        print("All.f2");
    }

    @Override
    public void g2() {
        print("All.g2");
    }

    @Override
    public void f3() {
        print("All.f3");
    }

    @Override
    public void g3() {
        print("All.g3");
    }

    @Override
    public void h() {
        print("All2.h");
    }
}
public class E15_AbstractsAndInterfaces {
    static void take1(Interface1 i) {
        i.f1();
        i.g1();
    }

    static void takes2(Interface2 i) {
        i.f2();
        i.g2();
    }

    static void takes3(Interface3 i) {
        i.f3();
        i.g3();
    }

    static void takeAll(All2 a) {
        a.f1();
        a.g1();
        a.f2();
        a.g2();
        a.f3();
        a.g3();
        a.h();
    }

    static void takesAbstract(Abstract a) {
        a.af();
    }

    public static void main(String[] args) {
        All2 a = new All2();
        take1(a);
        takes2(a);
        takes3(a);
        takeAll(a);
        takesAbstract(a);
    }
}
