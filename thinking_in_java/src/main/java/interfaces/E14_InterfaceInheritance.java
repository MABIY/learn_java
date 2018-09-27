package interfaces;

import static access.util.Print.print;

interface Interface1{
    void f1();

    void g1();
}

interface Interface2{
    void f2();

    void g2();
}

interface Interface3{
    void f3();

    void g3();
}

interface Multiple extends Interface1,Interface2,Interface3 {
    void h();
}

class Concrete{
    String s;

    public Concrete(String s) {
        this.s = s;
    }
}

class All extends Concrete implements Multiple {
    public All() {
        super("All");
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
        print("All.h");
    }
}
public class E14_InterfaceInheritance {
    static void takes1(Interface1 i) {
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

    static void takeAll(All a) {
        a.f1();
        a.g1();
        a.f2();
        a.g2();
        a.f3();
        a.g3();
        a.h();
    }

    public static void main(String[] args) {
        All a = new All();
        takes1(a);
        takes2(a);
        takes3(a);
        takeAll(a);
    }
}
