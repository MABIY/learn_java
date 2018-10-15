package exceptions;

// Following the instructions to the letter:
class MyException04 extends Exception {
    String msg;
    public MyException04(String msg) {
        this.msg = msg;
    }

    public void printMsg() {
        System.out.println("msg = " + msg);
    }
}

// Or take a more clever approach,
// nothing that string storage and printing are
// build into exception
class MyException2 extends Exception {
    public MyException2(String s) {
        super(s);
    }
}
public class E04_ExceptionClass {
    public static void main(String[] args) {
        try {
            throw new MyException04("MyException message");
        } catch (MyException04 e) {
            e.printMsg();
        }
        try {
            throw new MyException2("MyException message");
        } catch (MyException2 e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
