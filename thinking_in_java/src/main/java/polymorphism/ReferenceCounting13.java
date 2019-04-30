package polymorphism;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Add a finalize() method to ReferenceCounting.java to verify the termination
 * condition (see the Initialization & Cleanup chapter)
 **/
class Shared1 {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared1() {
        print("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    @Override
    protected void finalize() {
        if (refcount > 0) {
            print("Error: " + refcount + " Shared " + id + " objects in use");
        }
    }

    protected void dispose() {
        if (--refcount == 0) {
            print("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing1{
    private Shared1 shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing1(Shared1 shared) {
        print("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        print("Disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}
public class ReferenceCounting13 {
    public static void main(String[] args) {
        Shared1 shared = new Shared1();
        Composing1[] composing1s = {new Composing1(shared),
                new Composing1(shared), new Composing1(shared),
                new Composing1(shared), new Composing1(shared),
        };
        for (Composing1 c : composing1s) {
            c.dispose();
        }
        Composing1 composing1 = new Composing1(shared);
        Composing1 composing11 = new Composing1(shared);
        // Test finalize()
        shared.finalize();
        Shared1 shared1 = new Shared1();
        Composing1 composing12 = new Composing1(shared1);
        // Test sharedTest finalize()
        shared1.finalize();

    }
}
