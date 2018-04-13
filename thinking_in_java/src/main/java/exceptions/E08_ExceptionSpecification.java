package exceptions;

class Thrower {
//    public void f() {
//        throw new MyException("Inside f()");
//    }
    public void g() throws MyException1 {
        throw new MyException1("Inside g()");
    }
}
public class E08_ExceptionSpecification {
    public static void main(String[] args) {
        Thrower t = new Thrower();
        try {
            t.g();
        } catch (MyException1 e) {
            e.printMsg();
        }
    }
}
