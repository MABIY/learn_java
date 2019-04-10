package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 **/
public class StringOperators {
    public static void main(String[] args) {
        int x = 0, y = 1, z = 2;
        String s = "x, y, z";
        print(s + x  + y + z);
        // Converts x to a string
        print(x + " " + s);
        // Concatenation operator
        s += "(summed) =";
        print(s + (x + y + z));
        // Shorthand for Integer.toString()
        print("" + x);
    }
}
