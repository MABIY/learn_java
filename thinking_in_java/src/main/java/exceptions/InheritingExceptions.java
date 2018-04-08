package exceptions;

/**
 * Created by LiuHua on 18-4-8.
 */
class SimpleException extends Exception {}

public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            e.printStackTrace();
            System.out.println("Caught it!");
        }
    }
}
