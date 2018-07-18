package generics1;


interface FactoryI1<T>{
    T create(int arg);
}
class Foo<T>{
    private T x;

    public Foo(FactoryI1<T> factory) {
        x = factory.create(1);
    }
    //...
}

class IntegerFactory1 implements FactoryI1<Integer> {
    @Override
    public Integer create(int arg) {
        return new Integer(arg);
    }
}

class Widget1 {
    private final int id;

    public Widget1(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Widget " + id;
    }

    public static class Factory implements FactoryI1<Widget1> {
        @Override
        public Widget1 create(int arg) {
            return new Widget1(arg);
        }
    }
}

public class E23_FactoryConstraint2 {
    public static void main(String[] args) {
        new Foo<Integer>(new IntegerFactory1());
        new Foo<Widget1>(new Widget1.Factory());
    }
}
