package exceptions;

/**
 * @author lh
 * Modify Exercise 4 so  that the custom exception
 * class inherits from RuntimeException, and show
 * that the compiler allows you to leave out the
 * try block
 **/
class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String message) {
        super(message);
    }
}
public class E28_RuntimeExceptionClass {
    public static void main(String[] args) {
        throw new MyRuntimeException("MyRuntimeException msg");
    }
}
