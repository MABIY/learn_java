package innerclasses;

/**
 * @author lh
 * Implement reverseSelector() in Sequence.java.
 **/
class Sequence3{
    private Object[] objects;
    private int next;

    public Sequence3(int size) {
        objects = new Object[size];
    }

    public void add(Object x) {
        if (next < objects.length) {
            objects[next++] = x;
        }
    }

    private class ReverseSelector implements Selector {
        int i = objects.length - 1;
        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }
    }

    private class SequenceSelector implements Selector {
        private int i;
        @Override
        public boolean end() {
            return i == objects.length;
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

    public Selector selector() {
        return new SequenceSelector();
    }
    public Selector reverseSelector() {
        return new ReverseSelector();
    }

}
public class E22_GenRSelector {
    public static void main(String[] args) {
        Sequence3 sequence3 = new Sequence3(10);
        for (int i = 0; i < 10; i++) {
            sequence3.add(Integer.toString(i));
        }
        Selector selector = sequence3.reverseSelector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
