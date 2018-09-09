package operators;

import static org.greggordon.tools.Print.println;

public class DogCompare {
    public static void main(String[] args) {
        Dog spot = new Dog();
        spot.setSays("Spot");
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
        println("Comparsion: ");
        println("spot == butch: " + (spot == butch));
        println("spot.equals(butch): " + spot.equals(butch));
        println("butch.equals(spot): " + butch.equals(spot));
        println("Now assign: spot = butch");
        spot = butch;
        println("Compare again: ");
        println("spot == butch: " + (spot == butch));
        println("spot.equals(butch): " +spot.equals(butch));
        println("butch.equals(spot): " + butch.equals(spot));
        println("spot: ");
        spot.showName();
        spot.speak();
        println("Butch: ");
        butch.showName();
        butch.speak();

    }
}
