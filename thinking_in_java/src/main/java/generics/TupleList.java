package generics;

import net.lh.util.FourTuple;

import java.util.ArrayList;

/**
 * @author lh
 * Combining generic types to make complex generic types.
 **/
public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> vehicleAmphibianStringIntegerFourTuple : tl) {
            System.out.println(vehicleAmphibianStringIntegerFourTuple);
        }
    }
}
