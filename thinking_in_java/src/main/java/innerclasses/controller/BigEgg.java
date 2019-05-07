package innerclasses.controller;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * An inner class cannot be overriden like a method
 **/
class Egg{
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            print("Egg.Yolk");
        }
    }

    public Egg() {
        print("New Egg()");
        y = new Yolk();
    }
}

public class BigEgg extends Egg {
    public class Yolk{
        public Yolk() {
            print("BigEgg.Yolk");
        }
    }

    public static void main(String[] args) {
        BigEgg a = new BigEgg();
        a.new Yolk();
    }
}
