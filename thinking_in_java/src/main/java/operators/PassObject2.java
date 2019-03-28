package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * create a class containing a float and use it demonstrate aliasing during
 * method calls
 **/
class Box{
    float a;
}
/**
 * @author lh
 */
public class PassObject2 {
    static void f(Box y) {
        y.a = 2.71828f;
    }

    public static void main(String[] args) {
        Box x = new Box();
        x.a = 3.1416f;
        print("1: x.a = " + x.a);
        f(x);
        print("2: x.a = " + x.a);
    }
}
