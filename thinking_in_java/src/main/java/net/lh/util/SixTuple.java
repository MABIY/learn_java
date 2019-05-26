package net.lh.util;

/**
 * @author lh
 **/
public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A first, B second, C c, D d, E e, F f) {
        super(first, second, c, d, e);
        sixth = f;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
    }
}
