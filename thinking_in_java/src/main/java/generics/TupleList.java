package generics;

import generics.util.FourTuple;
import generics.util.Tuple;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**
 * @author: liuHua
 * @create: 2018-12-06 16:08
 **/

public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A, B, C, D>> {
	public static void main(String[] args) {
		TupleList<Vehicle,Amphibian,String,Integer> t1 = new TupleList<>();
		t1.add(TupleTest.h());
		t1.add(TupleTest.h());
		for (FourTuple<Vehicle, Amphibian, String, Integer> i : t1) {
			System.out.println(i);
		}
	}
}
