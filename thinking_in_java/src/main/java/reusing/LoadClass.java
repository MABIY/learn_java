package reusing;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Prove that class loading takes place only once. Prove that loading may be caused
 * by either the creation of take first instance of the that class of by access of
 * a static member
 **/
class Ar {
    static int j = printInit("Ar.j initialized");

    static int printInit(String s) {
        print(s);
        return 1;
    }

    public Ar() {
        print("A() constructor");
    }
}

class Br extends Ar {
    static int k = printInit("Br.k initialized");

    public Br() {
        print("B() constructor");
    }
}

class Cr {
    static int n = printInitC("Cr.n initialized");
    static Ar a = new Ar();

    public Cr() {
        print("Cr() constructor");
    }

    static int printInitC(String s) {
        print(s);
        return 1;
    }

}

class Dr{
    public Dr() {
        print("Dr() constructor");
    }
}

public class LoadClass extends Br {
    static int i = printInit("LoadClass.i initialized");

    public LoadClass() {
        print("LoadingClass() constructor");
    }

    public static void main(String[] args) {
        // accessing static main cause loading (and initialization)
        // of A B & loadClass
        print("hi");
        // call constructors from loaded classes:
        LoadClass lc = new LoadClass();
        // call to static field loads & initializes C:
        print(Cr.a);
        // call to constructor loads D:
        Dr d = new Dr();
    }
}
