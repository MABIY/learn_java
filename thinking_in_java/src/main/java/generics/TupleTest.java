package generics;

import net.lh.util.FiveTuple;
import net.lh.util.FourTuple;
import net.lh.util.ThreeTuple;
import net.lh.util.TwoTuple;

/**
 * @author lh
 **/
class Amphibian {
}

class Vehicle {
}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        // Autoboxing converts the int to Integer:
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
    }


    private static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> tts1 = f();
        System.out.println(tts1);
        // tts1.first = "there"; // Compile error:final
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
