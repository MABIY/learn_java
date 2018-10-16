package exceptions;

class Except1 extends Exception {

    public Except1(String thrown_by_baseWithException) {
    }
}
class BaseWithException{
    public BaseWithException() throws Except1{
        throw new Except1("thrown by BaseWithException");
    }
}

class DerivedWE extends BaseWithException {
    // Produces compile-time error:
    // unreported exception Except1
    //! public DerivedWE() {}
    // Gives compile error: call to super must be first statement in constructor:
    // public DerivedWE() {
    //     try {
    //         super();
    //     } catch (Except1 e) {
    //
    //     }
    // }
    public DerivedWE() throws Except1 {
    }
}
public class E21_ConstructorException {
    public static void main(String[] args) {
        try {
            new DerivedWE();
        } catch (Except1 except1) {
            System.out.println("Caught " + except1);
        }
    }
}
