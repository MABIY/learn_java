package generics;

/*
 * Modify FactoryConstraint.java so that create()
 * takes an argument
 */
interface FactoryI23<T> {
    T create(int arg);
}

class Foo23<T> {
    private T x;

    public Foo23(FactoryI23<T> factoryI23) {
        x = factoryI23.create(1);
    }
}

class IntegerFactory23 implements FactoryI23<Integer> {
    @Override
    public Integer create(int arg) {
        return new Integer(arg);
    }
}

class Widget23{
    private final int id;

    public Widget23(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Widget23{" +
                "id=" + id +
                '}';
    }

    public static class Factory implements FactoryI23<Widget23> {
        @Override
        public Widget23 create(int arg) {
            return new Widget23(arg);
        }
    }

}

public class E23_FactoryConstraint2 {
    public static void main(String[] args) {
        new Foo23<Integer>(new IntegerFactory23());
        new Foo23<Widget23>(new Widget23.Factory());
    }
}
