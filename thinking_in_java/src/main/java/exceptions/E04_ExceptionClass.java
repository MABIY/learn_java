package exceptions;

/**
 * @author lh
 * Create your own exception class using the
 * extends keyword. Write a constructor for this
 * class that takes a String argument and stores
 * it inside the object with a String reference.
 * Wirte a method that prints out the stored String
 **/
class MyException04 extends Exception {
    String msg;


    public MyException04(String message) {
        this.msg = message;
    }
    public void printMsg() {
        System.out.println("msg = " + msg);
    }
}

// or take a more clever approach
// nothing that string storage and printing are
// built into Exception
class MyException2 extends Exception {
    public MyException2(String message) {
        super(message);
    }
}
public class E04_ExceptionClass {
    public static void main(String[] args) {
        try {
            throw new MyException04("MyException04 message");
        } catch (MyException04 e) {
            e.printMsg();
        }
        try {
            throw new MyException2("MyException2 message");
        } catch (MyException2 e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
