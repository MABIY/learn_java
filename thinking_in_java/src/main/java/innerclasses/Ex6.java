package innerclasses;

import innerclasses.ex6Base.Ex6Base;
import innerclasses.ex6Interface.Ex6Interface;

/**
 * @author lh
 * Create an interface with at least one method, in its own package. Create
 * a class in a separate package. Addd a third package, inherit from your class and
 * inside a method, return an object of the protected inner class, upcasting
 * to the interface during the return.
 **/
public class Ex6 extends Ex6Base {
    Ex6Interface getBaseInner() {
        return this.new Ex6BaseInner();
    }

    public static void main(String[] args) {
        Ex6 ex = new Ex6();
        System.out.println(ex.getBaseInner().say());
    }
}
