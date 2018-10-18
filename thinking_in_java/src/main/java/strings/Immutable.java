package strings;

import static net.mindview.util.Print.print;

public class Immutable {
    public static String upCast(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        print(q); // howdy
        String qq = upCast(q);
        print(qq); //HOWDY
        print(q); //howdy
    }
}
