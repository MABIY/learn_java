package generics;

import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;
import generics.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-22 09:22
 * Using adapters to simulate latent typing
 **/
interface Addable<T> {
	void add(T t);
}

public class Fill2 {
	// Classtoken version
	public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
		for (int i = 0; i < size; i++) {
			try {
				addable.add(classToken.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	// Generator version:
	public static <T> void fill(Addable<T> addable,
								Generator<T> generator, int size) {
		for (int i = 0; i < size; i++) {
			addable.add(generator.next());
		}
	}
	
}

//To adapt a base type, you must use composition.
// Make  any collection addable using composition:
class AddableColllectionAdapter<T> implements Addable<T> {
	private Collection<T> c;
	
	public AddableColllectionAdapter(Collection<T> c) {
		this.c = c;
	}
	
	@Override
	public void add(T t) {
		c.add(t);
	}
}

//  A helper to capture the type automatically:
class Adapter {
	public static <T> Addable<T> collectionAdapter(Collection<T> c) {
		return new AddableColllectionAdapter<>(c);
	}
}

//To adapt a specific type, you can use inheritance.
// make a simpleQueue addable using inheritance
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T>{
	@Override
	public void add(T t) {
		super.add(t);
	}
}
class Fill2Test{
	public static void main(String[] args) {
		//Adapt a Collection:
		List<Coffee> carrier = new ArrayList<>();
		Fill2.fill(
				new AddableColllectionAdapter<>(carrier),Coffee.class,3
		);
		
		//Helper method captures the type:
		Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class,2);
		
		for (Coffee c : carrier) {
			print(c);
		}
		
		print("----------");
		//Use an adapted class:
		AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
		Fill2.fill(coffeeQueue, Mocha.class,4);
		Fill2.fill(coffeeQueue, Latte.class, 1);
		for (Coffee c : coffeeQueue) {
			print(c);
		}
	}
}
