package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Demonstrates short-circuiting behavior
 * with logical operators
 **/
public class ShortCircuit {
    static boolean test1(int val) {
        print("test1(" + val + ")");
        print("result: " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        print("test2(" + val + ")");
        print("result: " + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        print("test3(" + val + ")");
        print("result: " + (val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        boolean b = test1(0) && test1(2) && test3(2);
        print("expression is " + b);
    }
}
