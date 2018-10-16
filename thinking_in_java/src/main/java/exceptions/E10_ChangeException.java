package exceptions;

class AnException extends Exception {
}

class AnotherException extends Exception{}

public class E10_ChangeException {
    public void g() throws AnException {
        throw new AnException();
    }

    public void f() throws AnotherException {
        try{
            g();
        } catch (AnException e) {
            throw new AnotherException();
        }
    }

    public static void main(String[] args) {
        E10_ChangeException ce = new E10_ChangeException();
        try{
            ce.f();
        } catch (AnotherException e) {
            System.out.println("Caught " + e);
        }
    }
}
