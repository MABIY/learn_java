package reusing;

import static access.util.Print.print;

class Simple{
    String s;

    public Simple(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }

    public void setString(String sNew) {
        s = sNew;
    }
}

class Second{
    Simple simple;
    String s;

    public Second(String s) {
        this.s = s;
    }

    public void check() {
        if (simple == null) {
            print("not initialized");
        } else {
            print("initialized");
        }
    }

    private Simple lazy() {
        if (simple == null) {
            print("Creating Simple");
            simple = new Simple(s);
        }
        return simple;
    }

    public Simple getSimple() {
        return lazy();
    }

    public void setSimple(String sNew) {
        lazy().setString(sNew);
    }
    @Override
    public String toString() {
        return lazy().toString();
    }
}
public class E01_Composition {
    public static void main(String[] args) {
        Second second = new Second("Init String");
        second.check();
        print(second.getSimple());
        second.check();
        print(second); // toString() call
        second.setSimple("New String");
        print(second);
    }
}
