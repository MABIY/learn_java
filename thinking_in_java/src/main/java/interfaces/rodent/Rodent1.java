package interfaces.rodent;



import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify Exercise 9 in the pervious chapter so that Rodent is an abstract class.
 * Make the methods of Rodnet abstract whenever possible.
 **/

abstract class Rodent{
    private String name = "Rodent";

    abstract protected void eat();

    abstract protected void run();

    abstract protected void sleep();

    @Override
    abstract public String toString();
}

class Mouse extends Rodent{
    private String name = "Mouse";

    @Override
    protected void eat() {
        print("mouse.eat()");
    }

    @Override
    protected void run() {
        print("Moouse.run()");
    }

    @Override
    protected void sleep() {
        print("Mouse.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Rat extends Rodent {
    private String name = "Rat";
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

class Squirrel extends Rodent{
    private String name = "Squirrel";
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

public class Rodent1 {
    private static RandomRodentGenerator1 gen = new RandomRodentGenerator1();

    public static void main(String[] args) {
        // Error: cannot instantiate abstract class:
        // Rodent x = new Rodent();
        // But ok to crate array to be downcast ot derived objects:
        Rodent[] rodents = new Rodent[10];
        for (Rodent r : rodents) {
            r = gen.next();
            print(r + ": ");
            r.eat();
            r.run();
            r.sleep();
        }
    }
}
