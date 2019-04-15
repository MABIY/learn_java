package initialization;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Specifiying initial values in a class definition.
 **/
class Bowl{
    public Bowl(int marker) {
        print("Bowl(" + marker + ")");
    }

    void f1(int maker) {
        print("f1(" + maker + ")");
    }
}

class Table{
    static Bowl bowl1 = new Bowl(1);

    public Table() {
        print("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        print("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public Cupboard() {
        print("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        print("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}
public class StaticInitialization {
    public static void main(String[] args) {
        print("Creating new Cupboard() in main");
        new Cupboard();
        print("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
