package exceptions;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Further embellishment of exception classes.
 **/
class MyException22 extends Exception {
    private int x;

    public MyException22() {
    }

    public MyException22(String message) {
        super(message);
    }

    public MyException22(String message, int x) {
        super(message);
        this.x = x;
    }

    public int val() {
        return x;
    }

    @Override
    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}
public class ExtraFeatures {
    public static void f() throws MyException22 {
        print("Throwing MyException2 from f()");
        throw new MyException22();
    }
    public static void g() throws MyException22 {
        print("Throwing MyException2 from g()");
        throw new MyException22("Originated in h()", 47);
    }

    public static void h() throws MyException22 {
        print("Throwing MyException2 from h()");
        throw new MyException22("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException22 e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException22 myException22) {
            myException22.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException22 myException22) {
            myException22.printStackTrace(System.out);
        }
    }
}
