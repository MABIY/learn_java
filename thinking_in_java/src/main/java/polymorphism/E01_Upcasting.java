package polymorphism;

import polymorphism.cycle.Bicycle;
import polymorphism.cycle.Cycle;
import polymorphism.cycle.TricyCle;
import polymorphism.cycle.Unicycle;

public class E01_Upcasting {
    public static void ride(Cycle c) {}

    public static void main(String[] args) {
        ride(new Cycle()); //No upcasting
        ride(new Unicycle()); //Upcast
        ride(new Bicycle()); //Upcast
        ride(new TricyCle()); //Upcast
    }
}
