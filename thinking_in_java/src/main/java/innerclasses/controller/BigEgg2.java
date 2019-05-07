package innerclasses.controller;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Proper inheritance of an inner class.
 **/
class Egg2{
    protected class Yolk{
        public Yolk() {
            print("Egg2.Yolk()");
        }
        public void f() {
            print("Egg2.Yolk.f()");
        }
    }
    private Yolk y = new Yolk();

    public Egg2() {
        print("New Egg2()");
    }

    public void insertYolk(Yolk yy) {
        y = yy;
    }
    public void g() {
        y.f();
    }
}

public class BigEgg2 extends Egg2 {
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            print("BigEgg2.Yolk()");
        }
        @Override
        public void f() {
            print("BIgEgg2.Yolk.f()");
        }
    }


    public BigEgg2() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}
