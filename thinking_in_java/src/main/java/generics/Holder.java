package generics;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @author lh
 **/
public class Holder<T> {
    private T value;

    public Holder(T value) {
        this.value = value;
    }

    public Holder() {
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        // Holder<Fruit> fruit = apple; // Cannot upcast
        Holder<? extends Fruit> fruit = apple; //ok
        Fruit p = fruit.get();
        d = (Apple) fruit.get(); // Returns 'Object'
        try {
            Orange a = (Orange) fruit.get(); //No warning
        } catch (Exception e) {
            System.out.println(e);
        }
        // fruit.set(new Apple()); //Cannot call set()
        // fruit.set(new Fruit()); //Cannot call set()
        System.out.println(fruit.equals(d));
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}
