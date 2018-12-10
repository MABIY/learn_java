package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-10 20:58
 **/

public class ListOfGenerics<T> {
	private List<T> array = new ArrayList<>();
	
	public void add(T item) {
		array.add(item);
	}
	
	public T get(int index) {
		return array.get(index);
	}
}
