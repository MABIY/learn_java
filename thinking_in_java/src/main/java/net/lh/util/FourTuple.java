package net.lh.util;

/**
 * @author lh
 **/
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;
    public FourTuple(A first, B second, C c, D d) {
        super(first, second, c);
        fourth = d;
    }
}
