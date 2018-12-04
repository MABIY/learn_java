package generics.coffee;

import generics.util.Generator;

import java.util.Iterator;

/**
 * @author: liuHua
 * @create: 2018-12-04 15:36
 **/

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{
	private Class[] types = {
			Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class
	};
	//fixme
	@Override
	public Coffee next() {
		return null;
	}
	
	@Override
	public Iterator<Coffee> iterator() {
		return null;
	}
}
