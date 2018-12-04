package generics.util;

/**
 * @author: liuHua
 * @create: 2018-12-04 14:04
 **/

public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
	public final C third;
	public ThreeTuple(A first, B second,C third) {
		super(first, second);
		this.third = third;
	}
	
	@Override
	public String toString() {
		return "ThreeTuple{" +
				"third=" + third +
				", first=" + first +
				", second=" + second +
				'}';
	}
}
