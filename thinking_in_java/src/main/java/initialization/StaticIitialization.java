package initialization;

import javafx.scene.control.Tab;

import static net.mindview.util.Print.print;

class Bow1 {
    public Bow1(int marker) {
        print("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        print("f1(" + marker + ")");
    }
}

class Table {
    static Bow1 bow1 = new Bow1(1);

    Table() {
        print("Table()");
        bow2.f1(1);
    }

    void f2(int marker) {
        print("f2(" + marker + ")");
    }

    static Bow1 bow2 = new Bow1(2);
}

class Cupboard {
    Bow1 bow3 = new Bow1(3);
    static Bow1 bow4 = new Bow1(4);
    Cupboard() {
        print("Cupboard()");
        bow4.f1(2);
    }

    void f3(int marker) {
        print("f3(" + marker + ")");
    }

    static Bow1 bow5 = new Bow1(5);
}
public class StaticIitialization {
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
