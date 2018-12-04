package generics.util;

/**
 * @author: liuHua
 * @create: 2018-12-04 14:07
 **/

public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
	public final E e;
	
	public FiveTuple(A first, B second, C third, D d, E e) {
		super(first, second, third, d);
		this.e = e;
	}
	
	@Override
	public String toString() {
		return "FiveTuple{" +
				"e=" + e +
				", d=" + d +
				", third=" + third +
				", first=" + first +
				", second=" + second +
				'}';
	}
}
