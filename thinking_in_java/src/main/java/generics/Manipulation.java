package generics;

/**
 * @author lh
 * {CompileTimeError} (Won't compile)
 **/
class Manipulator<T> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    // Error: cannot find symbol: method f():
    public void manipulate() {
        // obj.f();
    }
}

public class Manipulation {
    public Manipulation() {
    }

    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
