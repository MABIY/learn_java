package generics;

import generics.util.FiveTuple;
import generics.util.FourTuple;
import generics.util.ThreeTuple;
import generics.util.TwoTuple;

/**
 * @author: liuHua
 * @create: 2018-12-04 14:17
 **/

class Amphibian{}
class Vehicle{}
public class TupleTest {
	static TwoTuple<String,Integer> f() {
		// Autoboxing coverts the int to Integer:
		return new TwoTuple<>("hi", 47);
	}
	
	static ThreeTuple<Amphibian,String,Integer> g() {
		return new ThreeTuple<>(new Amphibian(), "hi", 47);
	}
	
	static FourTuple<Vehicle,Amphibian,String,Integer> h() {
		return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
	}
	
	static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
		return new FiveTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	
	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		// ttsi.first = "there"; // Compile error: final
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
}
