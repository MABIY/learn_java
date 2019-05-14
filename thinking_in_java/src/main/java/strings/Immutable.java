package strings;

import static net.lh.util.Print.print;

/**
 * @author lh
 */
public class Immutable {
    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        print(q); // howdy
        String qq = upcase(q);
        print(qq); //HOWDY
        print(q); // howdy
    }
}
