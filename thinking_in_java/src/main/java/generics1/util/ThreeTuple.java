package generics1.util;

public class ThreeTuple<A,B,C> extends TwoTuple<A,B>{
    public final C third;
    public ThreeTuple(A first, B second,C three) {
        super(first, second);
        third = three;
    }

    @Override
    public String toString() {
        return "(" +first + ", " + second + ". " +third+ ")";
    }
}
