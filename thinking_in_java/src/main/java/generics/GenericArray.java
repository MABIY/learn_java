package generics;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-10 21:11
 **/

public class GenericArray<T> {
	private T[] array;
	
	public GenericArray(int sz) {
		array = (T[]) new Object[sz];
	}
	
	
	public void put(int index, T item) {
		array[index] = item;
	}
	
	public T get(int index) {
		return array[index];
	}
	
	// Method that exposes the underlying representation
	public T[] rep() {
		return array;
	}
	
	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<>(10);
		gai.put(1,1);
		// Integer[] ia = gai.rep();
		Object[] oa = gai.rep();
		System.out.println(Arrays.toString(oa));
		
	}
}
