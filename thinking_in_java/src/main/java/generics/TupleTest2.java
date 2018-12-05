package generics;

import generics.util.FiveTuple;
import generics.util.FourTuple;
import generics.util.ThreeTuple;
import generics.util.TwoTuple;

import static generics.util.Tuple.tuple;

/**
 * @author: liuHua
 * @create: 2018-12-05 15:55
 **/

public class TupleTest2 {
	static TwoTuple<String,Integer> f() {
		return tuple("hi", 47);
	}
	
	static TwoTuple f2() {
		return tuple("hi", 47);
	}
	
	static ThreeTuple<Amphibian,String,Integer> g() {
		return tuple(new Amphibian(), "hi", 47);
	}
	
	static FourTuple<Vehicle,Amphibian,String,Integer> h() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}
	
	static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	
	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
}
