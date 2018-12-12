package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-12 11:36
 **/

public class GenericWriting {
	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}
	
	static List<Apple> apples = new ArrayList<>();
	
	static List<Fruit> fruit = new ArrayList<>();
	
	static void f1() {
		writeExact(apples, new Apple());
		writeExact(fruit,new Apple());
	}
	
	static <T> void writeWithWildcard(List<? super T> list, T item) {
		writeWithWildcard(apples,new Apple());
		writeWithWildcard(fruit, new Apple());
	}
}
