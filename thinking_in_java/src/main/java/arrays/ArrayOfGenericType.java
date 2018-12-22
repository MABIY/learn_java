package arrays;

/**
 * @author: liuHua
 * @create: 2018-12-22 21:21
 **/

public class ArrayOfGenericType<T> {
	T[] array; //OK
	
	public ArrayOfGenericType(int size) {
		// array = new T[size]; // Illega
		array = (T[]) new Object[size]; // "unchecked" warning
	}
	
	//Illegal:
	// public <U> U[] makeArray() {
	// 	return new U[10];
	// }
}
