package operators;

import static org.greggordon.tools.Print.println;

public class StringOperators {
    public static void main(String[] args) {
        int x = 0, y = 1, z = 2;
        String s = " x, y ,z";
        println(s + x + y + z);
        println(x + " " + s); // Converts x to a String
        s += "(summed) = "; // Concatenation operator
        println(s + (x + y + z));
        println("" + x); // Shorthand for integer.toString()
    }
}
