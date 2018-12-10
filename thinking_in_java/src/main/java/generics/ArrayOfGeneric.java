package generics;

/**
 * @author: liuHua
 * @create: 2018-12-10 21:03
 **/

public class ArrayOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;
	
	public static void main(String[] args) {
		// Compiles: produces ClassCastException:
		// gia = (Generic<Integer>) new Object[SIZE];
		gia = (Generic<Integer>[]) new Generic[SIZE];
		gia[0] = new Generic<>();
		// gia[1] = new Object();  //Compile-time error
		// Discovers type mismatch at compile time:
		// gia[2] = new Generic<Double>();
	}
}
