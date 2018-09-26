package polymorphism;

import polymorphism.cycle.Cycle;
import polymorphism.cycle.TricyCle;
import polymorphism.cysle3.Bicycle;
import polymorphism.cysle3.Unicycle;

public class E17_RTTI {
    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[]{
                new Unicycle(), new Bicycle(), new TricyCle()
        };
        // cycles[0].balance();
        // cycles[1].balance();
        // cycles[2].balance();
        ((Unicycle)cycles[0]).balance(); //  Downcast/RTTI
        ((Bicycle)cycles[1]).balance(); // DownCast/RTTI
        ((Unicycle)cycles[2]).balance(); // Exception thrown
    }
}
