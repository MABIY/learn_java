package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 **/
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
        print(name);
    }

    void speak() {
        print(says);
    }
}
/**
 * @author lh
 */
public class DogCompare {
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
        Dog butch = new Dog();
        butch.setName("Butch");
        butch.setSays("Hello!");
        butch.showName();
        butch.speak();
        print("Comparison: ");
        print("spot == butch: " + (spot == butch));
        print("spot.equals(butch): " + spot.equals(butch));
        print("butch.equals(spot): " + butch.equals(spot));
        print("Now assign: spot =butch");
        spot = butch;
        print("Compare again: ");
        print("spot == butch: " + (spot == butch));
        print("spot.equals(butch): " + spot.equals(butch));
        print("butch.equals(spot): " + butch.equals(spot));
        print("Spot: ");
        spot.showName();
        spot.speak();
        print("Butch: ");
        butch.showName();
        butch.speak();
    }
}
