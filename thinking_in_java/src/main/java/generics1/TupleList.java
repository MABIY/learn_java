package generics1;

import generics1.util.FourTuple;

import java.util.ArrayList;

public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl) {
            System.out.println(i);
        }
    }
}
