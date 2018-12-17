package generics;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Objects;

/**
 * @author: liuHua
 * @create: 2018-12-12 11:20
 **/

public class Holder<T> {
	private T value;
	
	public Holder() {
	}
	
	public Holder(T value) {
		this.value = value;
	}
	
	public void set(T val) {
		value = val;
	}
	
	public T get() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		return value.equals(obj);
	}
	
	public static void main(String[] args) {
		Holder<Apple> Apple = new Holder<>(new Apple());
		Apple d = Apple.get();
		Apple.set(d);
		// Holder<Fruit> fruit = Apple; //Cannot upcasto
		Holder<? extends Fruit> fruit = Apple; // Ok
		Fruit p = fruit.get();
		d = (Apple).get();
		d = (Apple) fruit.get(); //Returns 'Object'
		try {
			Orange c = (Orange) fruit.get(); //No warning
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// fruit.set(new Apple()); // Cannot call set()
		// fruit.set(new Fruit()); // Cannot call set()
		System.out.println(fruit.equals(d));
	}
	
}