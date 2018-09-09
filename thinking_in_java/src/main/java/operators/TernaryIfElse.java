package operators;

import static org.greggordon.tools.Print.println;

public class TernaryIfElse {
    static int ternary(int i) {
        return i < 10 ? i * 100 : i * 10;
    }

    static int standardIfElse(int i) {
        if (i < 10) {
            return i * 100;
        } else {
            return i * 10;
        }
    }

    public static void main(String[] args) {
        println(ternary(9));
        println(ternary(10));
        println(standardIfElse(9));
        println(standardIfElse(10));
    }
}
