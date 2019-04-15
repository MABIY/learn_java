package initialization;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Calling constructors with "this"
 **/
public class Flower {
    int petalCount = 0;
    String s = "initial value";

    public Flower(int petalCount) {
        this.petalCount = petalCount;
        print("Constructor w/ int arg only, petalCount= " + petalCount);
    }

    public Flower(String s) {
        print("Constructor w/ String arg only, s = " + s);
        this.s = s;
    }

    public Flower( String s,int petalCount) {
        this(petalCount);
        // this(s); // Can't call two!
        this.s = s ; // Another use of "this"
        print("String & int args");
    }

    public Flower() {
        this("hi", 47);
        print("default constructor (no args)");
    }

    void printPetalCount() {
        // this(11); // Not inside non-constructor!
        print("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
