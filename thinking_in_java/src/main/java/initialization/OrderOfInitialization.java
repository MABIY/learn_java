package initialization;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Demonstrates initialization order
 *When the constructor is called to create a
 *Window object. you'll see a message
 **/
class Window{
    public Window(int marker) {
        print("WIndow(" + marker + ")");
    }
}

class House{
    Window w1 = new Window(1);  // Before constructor

    public House() {
        // Show that we're in the constructor
        print("House()");
        w3 = new Window(33); // Reinitialize w3
    }

    Window w2 = new Window(2); // After constructor

    void f() {
        print("f()");
    }

    Window w3 = new Window(3); // at end
}
public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f(); // Shows that construction is done
    }
}
