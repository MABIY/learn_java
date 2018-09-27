package interfaces;

import static access.util.Print.print;

interface Rodent2{
    void hop();

    void scurry();

    void reproduce();
}

class Mouse2 implements Rodent2 {
    @Override
    public void hop() {
        print("Mouse hopping");
    }

    @Override
    public void scurry() {
        print("Mouse scurrying");
    }

    @Override
    public void reproduce() {
        print("Making more Mice");
    }

    @Override
    public String toString() {
        return "Mouse";
    }
}

class Gerbil2 implements Rodent2 {
    @Override
    public void hop() {
        print("Gerbil hopping");
    }

    @Override
    public void scurry() {
        print("Gerbil scurrying");
    }

    @Override
    public void reproduce() {
        print("Making more Gerbils");
    }

    @Override
    public String toString() {
        return "Gerbil";
    }
}

class Hamster2 implements Rodent2{
    @Override
    public void hop() {
        print("Hamster hopping");
    }

    @Override
    public void scurry() {
        print("Hamster scurrying");
    }

    @Override
    public void reproduce() {
        print("Making more Hamsters");
    }

    @Override
    public String toString() {
        return "Hamster";
    }
}
public class E07_RodentInterface {
    public static void main(String[] args) {
        Rodent2[] rodents = {
                new Mouse2(),
                new Gerbil2(),
                new Hamster2()
        };

        for (Rodent2 r : rodents) {
            r.hop();
            r.scurry();
            r.reproduce();
            print(r);
        }
    }
}
