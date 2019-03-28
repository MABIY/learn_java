package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Passing objects to methods may not be
 * what you're used to
 **/
class Letter{
    char c;
}
/**
 * @author lh
 */
public class PassObject {
    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        print("1: x.c: " + x.c);
        f(x);
        print("2: x.c: " + x.c);
    }
}
