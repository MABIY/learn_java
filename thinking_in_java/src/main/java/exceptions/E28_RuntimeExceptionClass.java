package exceptions;

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
