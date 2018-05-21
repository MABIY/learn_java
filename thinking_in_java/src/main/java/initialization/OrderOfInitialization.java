package initialization;

class Window{
    public Window(int marker) {
        System.out.println("Window("+marker+")");
    }
}
class House{
    Window w1 = new Window(1);// Before constructor

    public House() {
        // Show that we're in the constructor:
        System.out.println("House()");
        w3 = new Window(33); //Reinitailize w3
    }

    Window w2 = new Window(2); // After constructor
    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3); // at end
}
public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f();// Shows that construction is done
    }
}
