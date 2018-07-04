package generics1;

import generics1.util.FiveTuple;

class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E>{
    public final F sixth;
    public SixTuple(A first, B second, C three, D four, E five,F six) {
        super(first, second, three, four, five);
        sixth = six;
    }

    @Override
    public String toString() {
        return "SixTuple{" +
                "sixth=" + sixth +
                ", fifth=" + fifth +
                ", fourth=" + fourth +
                ", third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
public class E03_SixTuple {
    static SixTuple<Vehicle,Amphibian,String,Float,Double,Byte> a() {
        return new SixTuple<Vehicle, Amphibian, String, Float, Double, Byte>(
                new Vehicle(), new Amphibian(), "hi", (float) 4.7, 1.1, (byte) 1
        );
    }

    public static void main(String[] args) {
        System.out.println(a());
    }
}
