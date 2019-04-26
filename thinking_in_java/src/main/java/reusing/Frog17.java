package reusing;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify Exercise 16 so that Frog overrides the method definitions from
 * the base class (provides new definitions using the same method signatures).
 * Note what happens in main()
 * (Exersice 16:Create a class called Amphibian. From this, inherit a class
 * called Frog. Put appropriate methods in the base class. In main(), create a
 * Frog and upcast it to Amphibian,and demonstrate that all the methods stil work.)
 **/
class Amphibian1{
    protected void swim() {
        print("Amphibian swim");
    }
    protected void speak() {
        print("Amphibian speak");
    }

    void eat() {
        print("Amphibian eat");
    }

    static void grow(Amphibian1 a) {
        print("Amphibian grow");
        a.eat();
    }
}
public class Frog17 extends Amphibian1{
    @Override
    protected void swim() {
        print("Frog swim");
    }

    @Override
    protected void speak() {
        print("Frog speak");
    }

    @Override
    void eat() {
        print("Frog eat");
    }

    static void grow(Amphibian1 a) {
        print("Frog grow");
        a.eat();
    }
    public static void main(String[] args) {
        Frog17 f = new Frog17();
        // call overridden base-class methods:
        f.swim();
        f.speak();
        f.eat();
        // upcast Frog17 to Amphibian argument:
        grow(f);
        // upcast Frog17 to Amphibian and call Amphibian method:
        Amphibian1.grow(f);
    }
}
