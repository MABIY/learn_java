package net.mindview.util;

/**
 * @author: liuHua
 * @create: 2018-12-15 20:42
 * Verify that fixedSizeStack in GenericCast.java generates exceptions
 * if you try to go out of its bounds. Does this mean that bounds-checking
 * code is not reuqired?
 **/
class FixedSizeStack<T>{
	private int index = 0;
	private Object[] storage;
	
	public FixedSizeStack(int size) {
		storage = new Object[size];
	}
	
	public int getIndex() {
		return index;
	}
	
	public void push(T item) {
		storage[index++] = item;
	}
	
	public T pop() {
		return (T)storage[--index];
	}
	
}
public class E32_FixedSizeStackTest {
	public static final int SIZE = 10;
	public static void main(String[] args) {
		FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
		for (String s : "A B C D E F G H I J".split(" ")) {
			strings.push(s);
		}
		//Runtime ArrayIndexOutOfBoundsException:
		// strings.push("oops"); // Bounds-checking required:
		for (int i = 0; i < SIZE; i++) {
			String s = strings.pop();
			System.out.println(s + " ");
		}
	}
}
