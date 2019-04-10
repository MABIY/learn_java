package operators;

/**
 * @author lh
 **/
public class Casting {
    public static void main(String[] args) {
        int i = 200;
        long lng = (long) i;
        // "Widening." so cast not really required
        lng = i;
        long lng2 = (long) 200;
        lng2 = 200;
        // Cast required
        i = (int) lng2;
    }
}
