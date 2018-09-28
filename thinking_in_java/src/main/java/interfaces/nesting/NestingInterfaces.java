package interfaces.nesting;

interface E {
    void g();

    interface G {
        void f();
    }

    //Refundant 'public'
    public interface H {
        void f();
    }
    //Cannot be private within an interface:
    //private interface I {}
}

class A {
    private D dRef;

    public D getD() {
        return new Dimp2();
    }

    public void receivedD(D d) {
        dRef = d;
        dRef.f();
    }

    interface B {
        void f();
    }

    public interface C {
        void f();
    }

    private interface D {
        void f();
    }

    public class BImp implements B {
        @Override
        public void f() {
        }
    }

    private class BImp2 implements B {
        @Override
        public void f() {
        }
    }

    class Cimp implements C {
        @Override
        public void f() {

        }
    }

    private class Cimp2 implements C {
        @Override
        public void f() {

        }
    }

    private class DImp implements D {
        @Override
        public void f() {

        }
    }

    public class Dimp2 implements D {
        @Override
        public void f() {
        }
    }
}

public class NestingInterfaces {
    public class Bimp implements A.B {
        @Override
        public void f() {
        }
    }

    class CImp implements A.C {
        @Override
        public void f() {

        }
    }

    // Cannot implement a private interface except
    // within that interface's defining class:
    // class Dimp implements A.D{
    //
    // }
    class Eimp implements E {
        @Override
        public void g() {
        }
    }

    class EGimp implements E.G {
        @Override
        public void f() {

        }
    }

    class Eimp2 implements E {
        @Override
        public void g() {

        }

        class EG implements E.G {
            @Override
            public void f() {

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        // Can't access A.D:
        //! A.D ad = a.getD();
        // Doesn't return anything but A.D:
        //A.Dimp2 di2 = a.getD();
        //Cannot
        //! a.getD().f();
        // Only anohter A can do anything with getD()
        A.Dimp2 a1 = new A().new Dimp2();
        A a2 = new A();
        a2.receivedD(a.getD());
    }

}
