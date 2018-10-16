package exceptions;

import innerclasses.Sequence;

interface Selector{
    boolean end();

    Object current();

    void next();

}
class SequenceFullException extends RuntimeException {
}
class Sequence2 {
    private Object[] objects;
    private int next;

    public Sequence2(int size) {
        objects = new Object[size];
    }

    public void add(Object x) {
        if (next < objects.length) {
            objects[next++] = x;
        } else {
            throw new SequenceFullException();
        }
    }
    private class SequenceSelector implements Selector{
        private int i;
        @Override
        public boolean end() {
            return objects.length==i;
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if (i < objects.length) {
                i++;
            }
        }
    }
}
public class E12_SequenceException {
    public static void main(String[] args) {
        Sequence2 sequence = new Sequence2(10);
        for (int i = 0; i < 11; i++) {
            sequence.add(Integer.toString(i));
        }
    }
}
