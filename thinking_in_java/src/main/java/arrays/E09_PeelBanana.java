package arrays;

import java.util.ArrayList;

/**
 * @author lh
 * Create the classes necessary for the Peel<Banana>
 * example and show that the compiler doesn't accept
 * it. Fix the problem using an ArrayList
 **/

class Banana{
    private final int id;

    public Banana(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Peel<T>{
    T fruit;

    public Peel(T fruit) {
        this.fruit = fruit;
    }

    void peel() {
        System.out.println("Peeling " + fruit);
    }
}

public class E09_PeelBanana {
    public static void main(String[] args) {
        // Compile error:
        // Peel<Banana>[] a = new Peel<Banana>[10];
        ArrayList<Peel<Banana>> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(new Peel<>(new Banana(i)));
        }
        for (Peel<Banana> bananaPeel : a) {
            bananaPeel.peel();
        }
    }
}
