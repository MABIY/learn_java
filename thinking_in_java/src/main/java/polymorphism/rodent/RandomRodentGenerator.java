package polymorphism.rodent;

import java.util.Random;

/**
 * @author lh
 * Create an inheritance hierarchy of Rodent:Mouse, Gerbil,Hamster,etc,In the
 * base class, provide methods that are common to all Rodents, and override these
 * in the derived classes to perform different behavirors depending on the specific
 * type of Rodent.Create an array of Rodent, fill it with different
 * specific types of Rodents, and call your base-class methods to see what happends
 **/
public class RandomRodentGenerator {
    private Random rand = new Random();
    public Rodent next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Mouse();
            case 1:
                return new Rat();
            case 2:
                return new Squirrel();
        }
    }

}
