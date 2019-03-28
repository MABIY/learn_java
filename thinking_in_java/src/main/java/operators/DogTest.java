package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * create a class called Dog containing two Strings: name and says:
 * In main(), create two dog objects with "spot" (who says "Ruff!") and
 * "scruffy" (who says "Wurf!"). Then display their names and what they say.
 **/
/**
 * @author lh
 */
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
