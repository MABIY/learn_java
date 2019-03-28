package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Demonstrates the ++ and -- operators
 **/
public class AutoInc {
    public static void main(String[] args) {
        int i = 1;
        print("i : " + i);
        print("++i : " + ++i); //Pre-increment
        print("i++ : " + i++); // Post-increment
        print("i : " + i);
        print("--1 : " + --i); // Pre-decrement
        print("1-- : " + i--); // Post-decrement
        print("i : " + i);
    }
}
