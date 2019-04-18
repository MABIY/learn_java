package reusing;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Create a simple class. Inside a second class, define a reference to an object of
 * the first class. Use lazy initialization ot instantiate this object
 **/
class Engine {
    private String s;

    public Engine() {
        print("Engine()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Airplane {
    private String fuselage, wings, tail;
    private Engine e;

    {
        System.out.println("tt");
    }

    public Airplane() {
        print("Inside Airplane()");
        fuselage = "Body";
        wings = "Airfoils";
        tail = "Empennage";
    }

    @Override
    public String toString() {
        if (e == null) { // lazy (delayed) initialization:
            e = new Engine();
        }
        return "fuselage = " + fuselage + ", " +
                "wings = " + wings + ", " +
                "tail = " + tail + ", " +
                "Engine = " + e;
    }

    public static void main(String[] args) {
        Airplane N1234 = new Airplane();
        print(N1234);
    }
}
