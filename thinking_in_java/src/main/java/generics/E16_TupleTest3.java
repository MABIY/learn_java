package generics;

import generics.util.*;
import org.omg.PortableInterceptor.INACTIVE;

import static generics.Tuple2.tuple;

/**
 * @author: liuHua
 * @create: 2018-12-05 16:10
 * Add a SixTuple to Tuple.java,and test it in TupleTest2.java
 **/
class Tuple2 extends Tuple {
	public static <A, B, C, D, E, F> SixTuple<A, B, C, D, E, F> tuple(A a, B b, C c, D d, E e, F f) {
		return new SixTuple<>(a, b, c, d, e, f);
	}
}
public class E16_TupleTest3 {
	static TwoTuple<String,Integer> f() {
		return tuple("hi", 47);
	}
	
	static ThreeTuple<Amphibian,String,Integer> g() {
		return tuple(new Amphibian(), "hi", 47);
	}
	
	static FourTuple<Vehicle,Amphibian,String, Integer> h() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}
	
	static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	
	static SixTuple<Vehicle,Amphibian,String,Integer,Double,Float> l() {
		return Tuple2.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1, 1.0F);
	}
	
	public static void main(String[] args) {
		System.out.println(f());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
		System.out.println(l());
	}
	
}
