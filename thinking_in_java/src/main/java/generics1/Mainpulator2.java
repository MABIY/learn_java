package generics1;

public class Mainpulator2<T extends HasF> {
    private T obj;

    public Mainpulator2(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}
