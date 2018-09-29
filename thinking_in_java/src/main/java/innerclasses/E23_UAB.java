package innerclasses;

interface U{
    void f();
    void g();
    void h();
}

class A23{
    public U getU() {
        return new U(){
            @Override
            public void f() {
                System.out.println("A.f");
            }

            @Override
            public void g() {
                System.out.println("A.g");
            }

            @Override
            public void h() {
                System.out.println("A.h");
            }
        };
    }
}

class B23{
    U[] ua;

    public B23(int size) {
        ua = new U[size];
    }

    public boolean add(U elem) {
        for (int i = 0; i < ua.length; i++) {
            if (ua[i] == null) {
                ua[i] = elem;
                return true;
            }
        }
        return false; //Couldn't find any space
    }

    public boolean setNull(int i) {
        if (i < 0 || i >= ua.length) {
            return false; // Value out of bounds
        }
        // (Normally) throw an exception
        ua[i] = null;
        return true;
    }

    public void callMethods() {
        for (int i = 0; i < ua.length; i++) {
            if (ua[i] != null) {
                ua[i].f();
                ua[i].g();
                ua[i].h();

            }
        }
    }
}
public class E23_UAB {
    public static void main(String[] args) {
        A23[] aa = {new A23(), new A23(), new A23()};
        B23 b = new B23(3);
        for (int i = 0; i < aa.length; i++) {
            b.add(aa[i].getU());
        }
        b.callMethods();
        System.out.println("****");
        b.setNull(0);
        b.callMethods();
    }
}
