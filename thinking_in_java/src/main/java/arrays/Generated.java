package arrays;

import generics.util.Generator;
import util.CollectionData;

import java.lang.reflect.Array;

/**
 * @author: liuHua
 * @create: 2018-12-23 20:00
 **/

public class Generated {
	// Fill an existing array:
	public static <T> T[] array(T[] a, Generator<T> gen) {
		return new CollectionData<T>(gen, a.length).toArray(a);
	}
	
	// Create a new array:
	public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
		T[] a = (T[]) Array.newInstance(type, size);
		return new CollectionData<T>(gen, size).toArray(a);
	}
	
}
