package polymorphism.rodent;


import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify exercise 9 so that it demonstrates the order of initialization of the
 * base classes and derived class. now add member objects to both the base and
 * derived classes, and show the order in which their initialization occurs during
 * construction
 **/
class Characteristic{
    private String s;

    public Characteristic(String s) {
        this.s = s;
        print("Creating Characteristic " + s);
    }
}

class Description{
    private String s;

    public Description(String s) {
        this.s = s;
        print("Creating Description " + s);
    }
}

class Rodent1{
    private String name = "Rodent1";
    private Characteristic c = new Characteristic("has tail");
    private Description d = new Description("small mammal");

    public Rodent1() {
        print("Rodent1()");
    }

    protected void eat() {
        print("Rodent1.eat()");
    }

    protected void run() {
        print("Rodent1.run()");
    }
    protected void sleep() {
        print("Rodent1.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Mouse1 extends Rodent1 {
    private String name = "Mouse";
    private Characteristic c = new Characteristic("Linkes cheese");
    private Description d = new Description("nocturnal");

    public Mouse1() {
        print("Mouse()");
    }

    @Override
    protected void eat() {
        print("Mouse1.eat()");
    }

    @Override
    protected void run() {
        print("Mouse1.run()");
    }

    @Override
    protected void sleep() {
        print("Mouse().sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Rat1 extends Rodent1 {
    private String name = "Rat";
    private Characteristic c = new Characteristic("larger");
    private Description d = new Description("black");

    public Rat1() {
        print("Rat()");
    }

    @Override
    protected void eat() {
        print("Rat.eat()");
    }

    @Override
    protected void run() {
        print("Rat.run()");
    }

    @Override
    protected void sleep() {
        print("Rat.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Squirrel1 extends Rodent1 {
    private String name = "Squirrel";
    private Characteristic c = new Characteristic("climbs trees");
    private Description d = new Description("likes nuts");

    public Squirrel1() {
        print("Squirrel()");
    }

    @Override
    protected void eat() {
        print("Squirrel.eat()");
    }

    @Override
    protected void run() {
        print("Squirrel.run()");
    }

    @Override
    protected void sleep() {
        print("Squirrel.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class RandomRodentGenerator1 {
    private Random rand = new Random();
    public Rodent1 next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Mouse1();
            case 1:
                return new Rat1();
            case 2:
                return new Squirrel1();
        }
    }

}

public class Rodent12 {
    private static RandomRodentGenerator1 gen = new RandomRodentGenerator1();

    public static void main(String[] args) {
        Rodent1[] rodent1s = new Rodent1[10];
        for (Rodent1 r : rodent1s) {
            r = gen.next();
            print(r);
        }
    }
}
