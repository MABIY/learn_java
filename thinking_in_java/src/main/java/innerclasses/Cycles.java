package innerclasses;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify the solution to Exercise 18 from the interfaces chapter to use
 * anonymous inner classes.
 * (Exercise 18, interface: Create a Cycle interface, with impleemtnatations Unicycle,
 * Bicycle and Tricycle. Create factories for each type of Cycle, and code that uses these
 * factories.)
 **/
interface Cycle{
    void ride();
}
interface CycleFactory{
    Cycle getCycle();
}
class Unicycle implements Cycle{
    private Unicycle() {
        print("Unicycle()");
    }

    @Override
    public void ride() {
        print("Ride Unicycle");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle{
    private Bicycle() {
        print("Bicycle()");
    }

    @Override
    public void ride() {
        print("Ride Bicycle");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle{
    private Tricycle() {
        print("Tricycle()");
    }

    @Override
    public void ride() {
        print("Ride Tricycle");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}
public class Cycles {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(Unicycle.factory);
        rideCycle(Bicycle.factory);
        rideCycle(Tricycle.factory);
    }
}
