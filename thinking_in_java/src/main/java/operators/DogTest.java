package operators;

import static org.greggordon.tools.Print.print;
import static org.greggordon.tools.Print.println;

class Dog{
    String name;
    String says;

    void setName(String n) {
        name = n;
    }

    void setSays(String s) {
        says = s;
    }

    void showName() {
        println(name);
    }
    void speak() {
        println(says);
    }
}
public class DogTest {
    public static void main(String[] args) {
        Dog spot = new Dog();
        spot.setName("Spot");
        spot.setSays("Ruff!");
        Dog scruffy = new Dog();
        scruffy.setName("Scruffy");
        scruffy.setSays("Wurf!");
        spot.showName();
        spot.speak();
        scruffy.showName();
        scruffy.speak();
    }
}
