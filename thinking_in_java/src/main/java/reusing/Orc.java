package reusing;

import static access.util.Print.print;

class Villanin {
    private String name;

    protected void set(String nm) {
        name = nm;
    }

    public Villanin(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}

public class Orc extends Villanin {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        set(name); //Available because it's protected
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc= new Orc("Linburger",12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }
}
