package generics;

/**
 * @author lh
 * "Generify" innderclass/Sequence.java
 **/
interface Selector<T>{
    boolean end();

    T current();

    void next();
}

class Sequence<T>{
    private Object[] items;
    private int next;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(T x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }
    private class SequenceSelector implements Selector<T>{
        private int i;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public T current() {
            return (T) items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }
    public Selector<T> selector() {
        return new SequenceSelector();
    }
}
public class E04_GenericSequence {
    public static void main(String[] args) {
        Sequence<String> sequence = new Sequence<>(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector<String> selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
