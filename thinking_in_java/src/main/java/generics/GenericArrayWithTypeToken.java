package generics;

import java.lang.reflect.Array;

/**
 * @author: liuHua
 * @create: 2018-12-10 21:24
 **/

public class GenericArrayWithTypeToken<T> {
	private T[] array;
	
	public GenericArrayWithTypeToken(Class<T> type,int sz) {
		array = (T[]) Array.newInstance(type, sz);
	}
	
	public void put(int index, T item) {
		array[index] = item;
	}
	
	public T get(int index) {
		return array[index];
	}
	//Expose the underlying representation:
	public T[] rep() {
		return array;
	}
	
	public static void main(String[] args) {
		GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class,10);
		
		Integer[] ia = gai.rep();
	}
}
