package generics;

import generics.util.TwoTuple;

import static generics.TupleTest2.f2;

/**
 * @author: liuHua
 * @create: 2018-12-05 16:02
 * "NOtice that f() returns a parameterized
 * TowTuple object, while f2() returns an
 * unparameterized TwoTuple object. The compiler
 * doesn't warn about f2() in this case because the
 * return value is not being used in a parameterized
 * fashion; in a sense, it is being "upcast" to an
 * unparameterized TwoTuple. However, if you were to try
 * to capture the result of f2() into a
 * parameterized TowTuple,the compiler would issue a
 * warning "
 *
 * Verify the previous statement
 **/

public class E15_LeftToReader {
	public static void main(String[] args) {
		TwoTuple<String, Integer> test = f2();
	}
}
