package net.lh.util;

/**
 * @author lh
 **/
public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E fifth;
    public FiveTuple(A first, B second, C c, D d, E e) {
        super(first, second, c, d);
        fifth = e;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth;
    }
}
