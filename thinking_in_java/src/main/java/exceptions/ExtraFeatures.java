package exceptions;

/**
 * Created by LiuHua on 18-4-8.
 */
class MyException3 extends Exception {
    private int x;
    public MyException3() { }

    public MyException3(String msg) {
        super(msg);
    }

    public MyException3(String message, int x) {
        super(message);
        this.x = x;
    }

    public int val() {
        return x;
    }

    public String getMessage() {
        return "Deatil Message: " + x + " " + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException3 {
        System.out.println("Throwing myException2 from f()");
        throw new MyException3();
    }
}
