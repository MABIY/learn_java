package generics;

/**
 * @author: liuHua
 * @create: 2018-12-17 11:56
 **/

public class BasicHolder<T>{
	T element;
	
	void set(T arg) {
		element = arg;
	}
	
	T get() {
		return element;
	}
	
	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
}
