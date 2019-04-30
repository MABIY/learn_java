package polymorphism.biking;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Using the Cycle hierarchy from Exercise 1, add a balance method() to
 * unicycle and Bicycle, but not to Tricycle. Create instances of all three
 * types and upcast them to an array of Cycle. Try to call balance() on each
 * element of the array an observe the  result. Downcast and call balance() and
 * observe what happens()
 **/
class Cycle17{
    private String name = "Cycle";

    public static void travel(Cycle c) {
        print("Cycle.ride() " + c);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Unicycle17 extends Cycle17 {
    private String name = "Unicycle";

    public void balance() {
        print("Balance Unicycle");
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

class Bicycle17 extends Cycle17 {
    private String name = "Bicycle";

    public void balance() {
        print("Balance Bicycle17");
    }
    @Override
    public String toString() {
        return name;
    }
}

class Tricycle17 extends Cycle17 {
    private String name = "Tricycle";

    @Override
    public String toString() {
        return name;
    }
}
public class Biking17 {
    public static void main(String[] args) {
        Cycle17[] ride = {
                new Unicycle17(),
                new Bicycle17(),
                new Tricycle17(),
        };
        // Compile time error: cannot find balance() method in Cycle17
        // for (Cycle17 c : ride) {
        //     c.balance();
        // }
        ((Unicycle17)ride[0]).balance();
        ((Bicycle17)ride[1]).balance();
        // Compile time error: no balance() in Tricycle:
        // ((Tricycle17) ride[2]).balance();
        // RTTI: ClassCastException: Tricycle cannot be cast to Bicycle
        // ((Bicycle17)ride[2]).balance();
    }
}
