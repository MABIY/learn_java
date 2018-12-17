package generics;


/**
 * @author: liuHua
 * @create: 2018-12-17 13:14
 **/

public class SelfBoundingMethods {
	static <T extends SelfBounded<T>> T f(T arg) {
		return arg.set(arg).get();
	}
	
	public static void main(String[] args) {
		A a = f(new A());
	}
}
