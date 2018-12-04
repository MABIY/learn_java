package generics.util;

/**
 * @author: liuHua
 * @create: 2018-12-04 14:06
 **/

public class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> {
	public final D d;
	public FourTuple(A first, B second, C third,D d) {
		super(first, second, third);
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "FourTuple{" +
				"d=" + d +
				", third=" + third +
				", first=" + first +
				", second=" + second +
				'}';
	}
}
