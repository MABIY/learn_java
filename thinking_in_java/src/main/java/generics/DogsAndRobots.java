package generics;

import typeinfo.pets.Dog;

import static net.lh.util.Print.print;

/**
 * @author lh
 * No latent typing in Java
 **/
class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        print("Woof!");
    }

    @Override
    public void sit() {
        print("Sitting");
    }
    public void reproduce() {

    }
}

class Robot implements Performs {
    @Override
    public void speak() {
        print("Click!");
    }

    @Override
    public void sit() {
        print("Clank!");
    }
    public void oilChange() {}
}

class Communicate{
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}
public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        Robot r = new Robot();
        Communicate.perform(d);
        Communicate.perform(r);
    }
}
