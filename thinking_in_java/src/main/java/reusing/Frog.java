package reusing;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Create a class called Amphibian. From this, inherit a class called Frog.
 * Put appropriate methods in the base class. In main(), create a Frog and upcast
 * it to Amphibian, and demonstrate that all the methods still work.
 **/
class Amphibian{
    protected void swim() {
        print("Amphibian swim");
    }

    protected void speak() {
        print("Amphibian speak");
    }

    void eat() {
        print("Amphibian eat");
    }

    static void grow(Amphibian a) {
        print("Amphibian grow");
        a.eat();
    }
}

public class Frog extends Amphibian {
    public static void main(String[] args) {
        Frog f = new Frog();
        // call base-class methods
        f.swim();
        f.speak();
        f.eat();
        //upcast Frog to Amphibian argument:
        Amphibian.grow(f);
    }
}
