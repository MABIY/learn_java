package generics.coffee;

import net.lh.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author lh
 * Generate different types of Coffee
 **/
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {
            Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class
    };

    public CoffeeGenerator() {
    }

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at the run time
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() { // No implement
            throw new UnsupportedOperationException();
        }
    }


    private static Random rand = new Random(47);

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }

}
