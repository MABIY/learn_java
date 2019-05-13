package exceptions;

/**
 * @author lh
 * Demonstrate that a derived-class constructor
 * cannot catch exceptons thrown by its base-class constructor
 **/
class Except1 extends Exception{
    public Except1(String message) {
        super(message);
    }
}
class BaseWithException{
    public BaseWithException() throws Except1 {
        throw new Except1("Thrown by BaseWithException");
    }
}

class DerivedWE extends BaseWithException {
    // Produces compile-time error:
    // unreported exception Except1
    // public DerivedWE() {
    // }
    // Gives compile error: call to super must be
    // first statement in constrctor:
    // public DerivedWE()  {
    //     try {
    //         super();
    //     } catch (Except1 except1) {
    //
    //     }
    // }


    public DerivedWE() throws Except1 {
    }
}
public class E21_ConstructorExceptions {
    public static void main(String[] args) {
        try {
            new DerivedWE();
        } catch (Except1 except1) {
            System.out.println("Caught " + except1);
        }
    }
}
