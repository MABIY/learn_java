package polymorphism;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Solution includes, in same pacakge ,the following two files:
 **/
public class Shared14 {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared14() {
        print("Creating "+ this);
    }

    public void addRef() {
        refcount++;
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }

    public void showRefcount() {
        print("refcount = " + refcount);
    }
}
