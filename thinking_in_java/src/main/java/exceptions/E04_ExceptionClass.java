package exceptions;

/**
 * Created by LiuHua on 18-4-8.
 */
class MyException1 extends Exception {
    String msg;

    public MyException1(String msg) {
        this.msg = msg;
    }

    public void printMsg() {
        System.out.println("msg = " + msg);
    }
}

// or take a more clever approach,
// noting that string storage and printing are
// built into Exception:

class MyException2 extends Exception {
    public MyException2(String message) {
        super(message);
    }
}

public class E04_ExceptionClass {
    public static void main(String[] args) {
        try {
            throw new MyException1("MyException1 message");
        } catch (MyException1 myException1) {
            myException1.printMsg();
        }

        try {
            throw new MyException2("MyException2 message");
        } catch (MyException2 myException2) {
            System.out.println("e.getMessage() = " + myException2.getMessage());
        }
    }
}
