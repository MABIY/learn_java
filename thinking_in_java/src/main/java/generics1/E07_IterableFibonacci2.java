package generics1;

import generics1.coffee.Fibonacci;
import generics1.coffee.IterableFibonacci;

import java.util.Iterator;

class IterableFibonacci1 implements Iterable<Integer> {
    private Fibonacci fib = new Fibonacci();
    private int n;

    public IterableFibonacci1(int n) {
        this.n = n;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                --n;
                return fib.next();
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class E07_IterableFibonacci2 {
    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.println(i + " ");
        }
    }
}
