package reusing;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Combining compositoon & inheritance
 **/
class Plate {
    public Plate(int i) {
        print("Plate constructor");
    }
}

class DinnerPlate extends Plate{
    public DinnerPlate(int i) {
        super(i);
        print("DinnerPlate constructor");
    }
}

class Utensil{
    public Utensil(int i) {
        print("Utensil constructor");
    }
}

class Spoon extends Utensil{
    public Spoon(int i) {
        super(i);
        print("Spoon constructor");
    }
}

class Fork extends Utensil{
    public Fork(int i) {
        super(i);
        print("Fork constructor");
    }
}

class Knife extends Utensil {
    public Knife(int i) {
        super(i);
        print("Knife constructor");
    }
}

// A cultural way of doing something:

class Custom{
    public Custom(int i) {
        print("Custom Constructor");
    }
}

public class PlaceSetting extends Custom {
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    public PlaceSetting(int i) {
        super(i  + i);
        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        print("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
}
