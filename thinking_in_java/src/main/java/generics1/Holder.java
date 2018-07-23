package generics1;

public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) {
        value = val;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);
        //Holder<Fruit> Furit = Apple;// Cannot upcast
        Holder<? extends Fruit> fruit = Apple;
        Fruit p = fruit.get();

        d = (Apple) fruit.get(); //Return 'Object'
        try {
            Orange c = (Orange) fruit.get(); // No warning
        } catch (Exception e) {
            System.out.println(e);
        }
//        fruit.set(new Apple());
//        fruit.set(new Fruit());
        System.out.println(fruit.equals(d)); //OK
    }
}
