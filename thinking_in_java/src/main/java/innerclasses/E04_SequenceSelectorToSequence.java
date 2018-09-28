package innerclasses;

class Sequence2{
    private Object[] items;
    private int next;

    public Sequence2(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
        public Sequence2 sequence() {
            return Sequence2.this;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public boolean check() {
        return this == ((SequenceSelector) selector()).sequence();
    }

}
public class E04_SequenceSelectorToSequence {
    public static void main(String[] args) {
        Sequence2 s = new Sequence2(10);
        System.out.println(s.check());
    }
}
