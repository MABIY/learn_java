package reusing;

import static net.lh.util.Print.print;

/**
 * @author lh
 * IN Beetle.java,inherit a specific type beetle from class Beetle,following
 * the same format as the existing classes. Trace and expain the output
 **/
class InsectS{
    private int i = 0;
    protected int j;

    public InsectS() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        print(s);
        return 47;
    }
}

class BeetleS extends InsectS {
    private int k = printInit("Beetle.k initialized");

    public BeetleS() {
        print("k = " + k);
        print("j = " + j);
    }

    private static int x2 = printInit("static Beetle.x2 initialized");
}

public class Scarab extends BeetleS {
    private int n = printInit("Scrarab.n initialized");

    public Scarab() {
        print("k = " + n);
        print("j = " + j);
    }

    private static int x3 = printInit("static Beetle.x3 initialized");

    public static void main(String[] args) {
        print("Scrab constructor");
        Scarab sc = new Scarab();
    }
}

