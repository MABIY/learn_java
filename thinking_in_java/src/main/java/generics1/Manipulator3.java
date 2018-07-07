package generics1;

public class Manipulator3 {
    private HasF obj;

    public Manipulator3(HasF obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}
