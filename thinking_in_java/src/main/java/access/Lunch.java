package access;

/**
 * @author lh
 * Demonstrates class specifiers. Make a class
 * effectively private with private constructors
 **/

class Soup1{
    public static String a = "";
    private Soup1() {}
    // (1) Allow creation via static method:
    public static Soup1 makeSoup() {
        return new Soup1();
    }
}
class Soup2{
    private Soup2(){}

    // (2) Create a static object and return a reference
    // upon request.(the "Singleton" pattern)
    private static Soup2 ps1 = new Soup2();

    public static Soup2 access() {
        return ps1;
    }

    public void f() {

    }
}
//Only one public class allowed per file:
public class Lunch {
    void testPrivate() {
        // Can't do this! private constructor
        // Soup1 soup = new Soup1();
    }

    void testStatic() {
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }

}
