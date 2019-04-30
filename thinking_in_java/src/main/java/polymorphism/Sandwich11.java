package polymorphism;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Add class Pickle to Sandwich.java
 **/
class Meal1{
    public Meal1() {
        print("Meal1()");
    }
}

class Bread1{
    public Bread1() {
        print("Bread1()");
    }
}

class Cheese1{
    public Cheese1() {
        print("Cheese1");
    }
}

class Lettuce1{
    public Lettuce1() {
        print("Lettuce1()");
    }
}

class Pickle1{
    public Pickle1() {
        print("Pickl1()");
    }
}

class Lunch1 extends Meal1 {
    public Lunch1() {
        print("Lunch1()");
    }
}

class PortableLunch1 extends Lunch1 {
    public PortableLunch1() {
        print("PortableLunch1");
    }
}

public class Sandwich11 extends PortableLunch1 {
    private Bread1 b = new Bread1();
    private Cheese1 c = new Cheese1();
    private Pickle1 p = new Pickle1();
    private Lunch1 l = new Lunch1();

    public Sandwich11() {
        print("Sandwich11()");
    }

    public static void main(String[] args) {
        new Sandwich11();
    }
}
