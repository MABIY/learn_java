package exceptions;

/**
 * @author lh
 * Repeat the previous exercise, but inside the
 * catch clause, wrap g()'s exception in a
 * RuntimeException
 **/
class AnException2 extends Exception{}

public class E11_ChangeToRuntimeException {
    public void g() throws AnException2 {
        throw new AnException2();
    }
    public void f() {
        try {
            g();
        } catch (AnException2 anException2) {
            throw new RuntimeException(anException2);
        }
    }

    public static void main(String[] args) {
        E11_ChangeToRuntimeException ce = new E11_ChangeToRuntimeException();
        ce.f();
    }
}
