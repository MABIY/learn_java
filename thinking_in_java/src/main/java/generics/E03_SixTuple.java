package generics;

import generics.util.FiveTuple;

/**
 * @author: liuHua
 * @create: 2018-12-04 14:26
 * Create and test a SixTuple generic
 **/
class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
	public final F f;
	public SixTuple(A first, B second, C third, D d, E e,F f) {
		super(first, second, third, d, e);
		this.f = f;
	}
	
	@Override
	public String toString() {
		return "SixTuple{" +
				"f=" + f +
				", e=" + e +
				", d=" + d +
				", third=" + third +
				", first=" + first +
				", second=" + second +
				'}';
	}
}
public class E03_SixTuple {
	static SixTuple<Vehicle,Amphibian,String,Float,Double,Byte> a() {
		return new SixTuple<>(new Vehicle(), new Amphibian(), "hi", (float) 4.7, 1.1, (byte) 1);
	}
	
	public static void main(String[] args) {
		System.out.println(a());
	}
}
