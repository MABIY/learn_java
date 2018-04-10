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

    public static void g() throws MyException3 {
        System.out.println("Throwing MyException3 from g()");
        throw new MyException3("Originated in h()", 47);
    }

    public static void h() throws MyException3 {
        System.out.println("Throwing MyException3 from h()");
        throw new MyException3("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException3 myException3) {
            myException3.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException3 myException3) {
            myException3.printStackTrace(System.out);
        }

        try {
            h();
        } catch (MyException3 myException3) {
            myException3.printStackTrace(System.out);
            System.out.println("e.val() = " + myException3.val());
        }
    }
}
