package generics.coffee;

import generics.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author: liuHua
 * @create: 2018-12-04 15:36
 **/

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{
	private Class[] types = {
			Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class
	};
	private static Random rand = new Random(47);
	
	public CoffeeGenerator() {
	}
	
	// for iteration:
	private int size = 0;
	
	public CoffeeGenerator(int size) {
		this.size = size;
	}
	
	
	
	@Override
	public Coffee next() {
		//fixme
	}
	
	@Override
	public Iterator<Coffee> iterator() {
		return null;
	}
}
