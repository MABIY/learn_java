package generics1.util;

public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {
    public final E fifth;
    public FiveTuple(A first, B second, C three, D four,E five) {
        super(first, second, three, four);
        fifth = five;
    }

    @Override
    public String toString() {
        return "FiveTuple{" +
                "fourth=" + fourth +
                ", third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
