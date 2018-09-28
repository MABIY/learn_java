package innerclasses;

class StringHolder{
    private String data;

    public StringHolder(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
public class E02_SequenceOfStringHolders {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(new StringHolder(Integer.toString(i)));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
