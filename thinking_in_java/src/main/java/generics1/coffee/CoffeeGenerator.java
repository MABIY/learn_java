package generics1.coffee;

import generics1.util.Generator;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee> {
    private Class[] type = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    @Override
    public Coffee next() {
        return null;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return null;
    }
}
