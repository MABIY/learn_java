package reusing;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author lh
 * Using "final" with method arguemnts
 **/
class Gizmo{
    public void spin() {}
}
public class FinalArguments {
    void with(final Gizmo g) {
        // g = new Gizmo(); // Illegal -- g is final
    }

    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g not final
        g.spin();
    }

    // void f(final int i) { // Can't change
    //     i++;
    // }
    // you can only read from a final primitive
    int g(final int i) {
        return i + 1;
    }
    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
}
