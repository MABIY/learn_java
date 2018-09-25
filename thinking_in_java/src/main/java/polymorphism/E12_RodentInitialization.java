package polymorphism;

import static access.util.Print.print;

class Member {
    public Member(String id) {
        print("Member constructor " + id);
    }
}

class Rodent2{
    Member m1 = new Member("r1"), me = new Member("r2");

    public Rodent2() {
        print("Rodent constructor");
    }

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
        return "Rodent2{" +
                '}';
    }
}

class Mouse2 extends Rodent2 {
    Member m1 = new Member("m1"), m2 = new Member("m2");

    @Override
    public void scurry() {
        print("Mouse scurring");
    }

    @Override
    public void reproduce() {
        print("Making more Mice");
    }

    public Mouse2() {
        print("Mouse constructor");
    }

    public void hop() {
        print("Mouse hopping");
    }
}

class Gerbil2 extends Rodent2 {
    Member m1 = new Member("g1"),m2 = new Member("g2");

    public Gerbil2() {
        print("Gerbil constructor");
    }

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
        return "Gerbil2{" +
                '}';
    }
}

class Hamster2 extends Rodent2 {
    Member m1 = new Member("h1"),m2 = new Member("h2");

    public Hamster2() {
        print("Hamster constructor");
    }

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
        return "Hamster2{" +
                '}';
    }
}
public class E12_RodentInitialization {
    public static void main(String[] args) {
        new Hamster2();
    }
}
