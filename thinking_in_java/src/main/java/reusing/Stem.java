package reusing;


import static net.mindview.util.Print.print;

/**
 * @author lh
 * Create a class called Root that contains an instance of each of the classes
 * (that you also create ) named component1, component2 and Ccompont3.Derive a
 * class Stem from Root that also contains an instance of each "component". All
 *  class should have defualt constructor that print a message about that class.
 **/
class Component1{
    public Component1() {
        print("Component1()");
    }
}

class Component2{
    public Component2() {
        print("Component2()");
    }
}

class Component3{
    public Component3() {
        print("Component3()");
    }
}

class Root{
    Component1 component1;
    Component2 component2;
    Component3 component3;

    public Root() {
        print("Root()");
    }
}

public class Stem extends Root {
    Component1 c12;
    Component2 c21;
    Component3 c31;

    public Stem() {
        print("Stem()");
    }

    public static void main(String[] args) {
        Stem s = new Stem();
    }
}
