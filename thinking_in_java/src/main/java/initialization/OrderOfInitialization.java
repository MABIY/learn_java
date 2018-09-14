package initialization;

import static net.mindview.util.Print.print;

class Window {
    Window(int marker) {
        print("WIndow(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1); //Before constructor

    public House() {
        //SHow that we're in the constructor
        print("House()");
        w3 = new Window(33);
    }
    Window w2 = new Window(2); //After constructor
    void f() {
        print("f()");
    }

    Window w3 = new Window(3); //At end
}
public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f();// Shows that construction is done
    }
}
