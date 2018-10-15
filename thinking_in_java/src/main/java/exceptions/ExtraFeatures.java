package exceptions;

import static net.mindview.util.Print.print;

class MyException0 extends Exception {
    private int x;
    public MyException0() {
    }

    public MyException0(String message) {
        super(message);
    }

    public MyException0(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() {
        return x;
    }

    public String getMessage() {
        return "Detail Message: " + " " + super.getMessage();
    }
}
public class ExtraFeatures {
    public static void f() throws MyException0 {
        print("Throwing myException0 from f()");
        throw new MyException0();
    }

    public static void g() throws MyException0 {
        print("Throwing MyException0 from g()");
        throw new MyException0("Originated in g()");
    }

    public static void h() throws MyException0 {
        print("Throwing MyException0 from h()");
        throw new MyException0("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException0 e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException0 myException0) {
            myException0.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException0 myException0) {
            myException0.printStackTrace(System.out);
            System.out.println("e.val() = " + myException0.val());
        }
    }
}
