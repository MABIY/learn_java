package interfaces;


import static interfaces.Meal.test;
import static net.mindview.util.Print.print;

/**
 * @author lh
 * In polymorphism.Sandwich.java, create an interface called FastFood (with
 * appropriate methods) and change Sandwich so that is also implements
 * FastFood.
 **/
interface FastFood{
    public static final int a = test();
    void cheeseburger();

    void fries();

    void softDrink();

}

class Meal{
    public static int test() {
        System.out.println("Meal.test");
        return 1;
    }
    public Meal() {
        print("Meal()");
    }
}
class Bread{
    public Bread() {
        print("Bread()");
    }
}

class Cheese{
    public Cheese() {
        print("Cheese()");
    }
}
class Lettuce{
    public Lettuce() {
        print("Lettuce()");
    }
}

class Lunch extends Meal{
    public Lunch() {
        print("Lunch()");
    }
}

class PortableLunch extends Lunch {
    public PortableLunch() {
        print("PortableLunch()");
    }
}

public class Sandwich8 extends PortableLunch implements FastFood {
    private Bread b = new Bread();
    private Cheese  c = new Cheese();
    private Lunch l = new Lunch();

    public Sandwich8() {
        print("Sandwich8");
    }

    @Override
    public void cheeseburger() {
        print("Cheeseburger");
    }

    @Override
    public void fries() {
        print("Fries");
    }

    @Override
    public void softDrink() {
        print("Soft Drink");
    }

    public static void main(String[] args) {
        Sandwich8 s = new Sandwich8();
        s.cheeseburger();
        s.fries();
        s.softDrink();
    }
}
