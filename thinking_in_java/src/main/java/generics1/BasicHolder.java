package generics1;

public class BasicHolder<T> {
    T elemet;

    void set(T arg) {
        elemet = arg;
    }

    T get() {
        return elemet;
    }

    void f() {
        System.out.println(elemet.getClass().getSimpleName());
    }
}
