package interfaces;

/**
 * @author lh
 * Create a class as abstract without including any abstract methods, and verify
 * that you cannot create any instances of that class.
 **/

abstract class Nogo1{
    public Nogo1() {
        System.out.println("Nogo1()");
    }
}

abstract class NOgo2{}

class Go1 extends Nogo1 {
    public Go1() {
        System.out.println("Go1()");
    }
}
public class Ex2 {
    public static void main(String[] args) {
        // Nogo1 and Nogo2 cannot be instantiated:
        // Nogo1 ng1 = new Nogo1();
        // Nogo2 ng2 = new Nogo2();
        // But NOgo1() constructor called during instatiation of child:
        Go1 g1 = new Go1();

    }
}
