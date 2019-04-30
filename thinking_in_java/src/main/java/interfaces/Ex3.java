package interfaces;

/**
 * @author lh
 * Create a base class with an abstract print() method that is overriden in a
 * derived class. The overridden version of the method prints the value of an int
 * variable defined in the derived clas. At  the point of definition of this
 * variable,give it a nonzero value. In the base-class constructor
 **/
abstract class Dad{
    protected abstract void print();

    Dad() {
        print();
    }
}

class Son extends Dad {
    private int i = 1;
    @Override
    protected void print() {
        System.out.println("Son.i = " + i);
    }
}

class Grandson extends Son {
    private int i = 2;

    @Override
    protected void print() {
        System.out.println("Grandson.i = " + i);
    }
}

public class Ex3 {
    public static void main(String[] args) {
        /* Process of initialization:
         * 1. Storage for son s allocated and initialized to binary zero
         * 2. Dad() called
         * 3. Son.print() called in Dad() (s.i = 0)
         * 4. Member initializers called in order(s.i = 1)
         * 5. Body of Son() called
         */
        Son s = new Son();
        s.print();
    }
}
