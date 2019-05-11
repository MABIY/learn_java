package exceptions;

/**
 * @author lh
 * Write a class with a method that throws an
 * exception of the type created in Exercise 4
 * Try compiling it  without an exception
 * specification to see what the compiler syas.
 * Add teh appropriate exception sepcification.
 * Try out your class and its exception inside a
 * try-catch clause.
 **/
class Thrower{
    public void f() {
        //Compiler gives an error: " unreported
        // exception MyException04; must be caught or declared
        // to be thrown"
        //! throw new MyException04("Inside f()");
    }

    public void g() throws MyException04 {
        throw new MyException04("Inside g()");
    }
}
public class E08_ExceptionSpecification {
    public static void main(String[] args) {
        Thrower t = new Thrower();
        try {
            t.g();
        } catch (MyException04 e) {
            e.printMsg();
        }
    }
}
