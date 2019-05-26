package generics;

import net.lh.util.SixTuple;

/**
 * @author lh
 * Create and test a SixTuple generic
 **/
public class E03_SixTuple {
    static SixTuple<Vehicle,Amphibian,String,Float,Double,Byte> a() {
        return new SixTuple<>(new Vehicle(), new Amphibian(), "hi", (float) 4.7, 1.1, (byte) 1);
    }

    public static void main(String[] args) {
        System.out.println(a());
    }
}
