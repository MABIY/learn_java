package interfaces;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Create a Cycle interface, with implementations Unicycle, Bicycle and
 * Tricycle. Create factories for each type of Cycle, and code that uses
 * these factories
 **/
interface Cycle{
    void ride();
}
interface CycleFactory{
    Cycle getCycle();
}
class Unicycle implements Cycle{
    @Override
    public void ride() {
        print("Ride Unicycle");
    }
}

class UnicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle{
    @Override
    public void ride() {
        print("Ride Bicycle");
    }
}
class BicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle{
    Tricycle() {
        print("Tricycle()");
    }

    @Override
    public void ride() {
        print("Ride Tricycle");
    }
}
class TricycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}
public class Cycles {
    public static void rideCycle(CycleFactory factory){
        Cycle c = factory.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(new UnicycleFactory());
        rideCycle(new BicycleFactory());
        rideCycle(new TricycleFactory());
    }
}
