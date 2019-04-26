package reusing;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Add a proper hierarchy of dispose() methods to all the classes of exercise 9.
 * EX 9: Create a class called Root that contains an instance of each  of the classes
 * (that you also create) named Compont1,Component2 and Component3. Derive a
 * class stem from Root that also contians an instance of each "component." All
 * classes should have defualt constructors that print a message about that class
 **/
class Component21{
    public Component21() {
        print("Component21()");
    }

    void dispose() {
        print("Componetn1.dispose()");
    }
}

class Component22{
    public Component22() {
        print("Componet22()");
    }

    void dispose() {
        print("Componetn22.dispose()");
    }
}

class Component23{
    public Component23() {
        print("Component3()");
    }

    void dispose() {
        print("Componet3.dispose()");
    }
}

class Root2{
    Component21 c1root;
    Component22 c2root;
    Component23 c3root;

    public Root2() {
        print("Root()");
        c1root = new Component21();
        c2root = new Component22();
        c3root = new Component23();
    }

    void dispose() {
        c3root.dispose();
        c2root.dispose();
        c1root.dispose();
        print("Root2.dispose()");
    }
}
public class Stem2 extends Root2{
    Component21 c1stem;
    Component22 c2stem;
    Component23 c3stem;

    public Stem2() {
        super();
        print("Stem2()");
        c1stem = new Component21();
        c2stem = new Component22();
        c3stem = new Component23();
    }

    @Override
    void dispose() {
        c3stem.dispose();
        c2stem.dispose();
        c1stem.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        Stem2 s = new Stem2();
        try {
            // Code and exception handling...
        }finally {
            s.dispose();
        }
    }
}
