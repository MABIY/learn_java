package generics;

import java.util.Iterator;

/**
 * @author lh
 * Use composition instead of inheritance to adapt Finbonacci ot make Iterable.
 **/
class IterableFibonacci7 implements Iterable<Integer> {
    private Fibonacci fib = new Fibonacci();
    private int n;

    public IterableFibonacci7(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
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
