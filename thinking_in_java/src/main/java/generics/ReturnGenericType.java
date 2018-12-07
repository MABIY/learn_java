package generics;

/**
 * @author: liuHua
 * @create: 2018-12-06 17:29
 **/

public class ReturnGenericType<T extends HasF> {
	private T obj;
	
	public ReturnGenericType(T x) {
		obj = x;
	}
	
	public T get() {
		return obj;
	}
}
