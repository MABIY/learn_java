package innerclasses;

class MNA{
    private void f() {
    }
    class A{
        private int b;
        private void g(){}
        public class B{
            private int a;
            void h(){
                g();
                f();
            };
        }
    }
}
public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
