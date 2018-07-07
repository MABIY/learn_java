package generics1;


class Manipulator<T> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    //Error: cannot find symbol: method f()
/*    public void mainpulate() {
        obj.f();
    }*/
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator  = new Manipulator<>(hf);
        //manipulator.manipulate();
    }
}


