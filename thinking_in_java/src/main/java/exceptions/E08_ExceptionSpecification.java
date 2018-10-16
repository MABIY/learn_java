package exceptions;

class Thrower{
    // Compiler gives an error: "unreported
    // exception MyException; must be caught
    // or declared to be thrown
    // public void f() {
    //     throw new MyException("Inside f()");
    // }
    public void g() throws MyException04{
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
