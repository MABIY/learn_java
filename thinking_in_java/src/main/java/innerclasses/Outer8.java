package innerclasses;

/**
 * @author lh
 * Determine whether an outer class ahs access to the private elements of
 * its inner class.
 **/
public class Outer8 {
    class Inner{
        private int ii1 = 1;
        private int ii2 = 2;
        private void showIi2() {
            System.out.println(ii2);
        }
        private void hi() {
            System.out.println("Innher hi");
        }
    }

    // Need to create objects to access private elements of Inner:
    int oi = new Inner().ii1;
    void showOi() {
        System.out.println(oi);
    }
    void showIi2() {
        new Inner().showIi2();
    }

    void outerHi() {
        new Inner().hi();
    }

    public static void main(String[] args) {
        Outer8 out = new Outer8();
        out.showOi();
        out.showIi2();
        out.outerHi();
    }


}
