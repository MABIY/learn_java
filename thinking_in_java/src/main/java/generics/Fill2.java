package generics;

import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;
import net.lh.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Using adapters to simulate latent typing
 **/
interface Addable<T>{
    void add(T t);
}
public class Fill2 {
    // classtoken version
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
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }

}

// To adapt a base type, you must use composition.
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}

// A helper to capture the type automatically:
class Adapter{
    public static <T> Addable<T> colllectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T t) {
        super.add(t);
    }
}

class Fill2Test{
    public static void main(String[] args) {
        // Adapt a Collection:
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(
                new AddableCollectionAdapter<>(carrier), Coffee.class, 3
        );
        Fill2.fill(Adapter.colllectionAdapter(carrier), Latte.class, 2);
        for (Coffee c : carrier) {
            print(c);
        }

        print("----------");
        // Use an dapted class:
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for (Coffee c : coffeeQueue) {
            print(c);
        }
    }
}
