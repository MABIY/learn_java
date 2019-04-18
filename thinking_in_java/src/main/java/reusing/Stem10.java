package reusing;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify the previous exercise so that each class only has non-default
 * constructors
 **/
class Component10{
    public Component10(byte b) {
        print("Component1(byte)");
    }
}

class Component20{
    public Component20(short s) {
        print("Component20(short)");
    }
}

class Component30{
    public Component30(int i) {
        print("Component3(int)");
    }
}

class Root10{
    Component10 c1root;
    Component20 c2root;
    Component30 c3root;

    public Root10(float f) {
        c1root = new Component10((byte) 0);
        c2root = new Component20((short) 0);
        c3root = new Component30(0);
        print("Root(foat)");
    }
}
public class Stem10 extends Root10{
    Component10 c1stem10;
    Component20 c2stem10;
    Component30 c3stem10;

    public Stem10(double b) {
        super(2.78f);
        c1stem10 = new Component10((byte)1);
        c2stem10 = new Component20((short) 1);
        c3stem10 = new Component30(1);
        print("Stem10(double)");
    }

    public static void main(String[] args) {
        Stem10 x = new Stem10(2.78);
    }
}
