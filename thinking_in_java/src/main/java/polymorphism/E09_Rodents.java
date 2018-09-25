package polymorphism;

import static access.util.Print.print;

class Rodent{
    public void hop() {
        print("Rodent hopping");
    }

    public void scurry() {
        print("Rodent scurrying");
    }

    public void reproduce() {
        print("Making more Rodents");
    }

    @Override
    public String toString() {
        return "Rodent{}";
    }
}

class Mouse extends Rodent{
    @Override
    public void hop() {
        print("Mouose hopping");
    }

    @Override
    public void scurry() {
        print("Mouse scurry");
    }

    @Override
    public void reproduce() {
        print("Making more Mice");
    }

    @Override
    public String toString() {
        return "Mouse{}";
    }
}

class Gerbil extends Rodent{
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
        return "Gerbil{}";
    }
}

class Hamster extends Rodent{
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
        return "Hamster{}";
    }
}
public class E09_Rodents {
    public static void main(String[] args) {
        Rodent[] rodents = {
                new Mouse(),
                new Gerbil(),
                new Hamster()
        };
        for (Rodent r : rodents) {
            r.hop();
            r.scurry();
            r.reproduce();
            print(r);
        }
    }
}
