package initialization;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Overloading based on the order of the argumenats
 **/
public class OverloadingOrder {
    static void f(String s, int i) {
        print("String: " + s + ", int: " + i);
    }

    static void f(int i, String s) {
        print("int: " + i + ", String: " + s);
    }

    public static void main(String[] args) {
        f("String first", 11);
        f(99, "Int first");
    }
}
