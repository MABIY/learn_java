package generics1.util;

public class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> {
    public final D fourth;
    public FourTuple(A first, B second, C three,D four) {
        super(first, second, three);
        fourth = four;
    }

    @Override
    public String toString() {
        return "FourTuple{" +
                "fourth=" + fourth +
                ", third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
