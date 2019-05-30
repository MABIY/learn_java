package generics;

import typeinfo.pets.Individual;

import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 * Add a speak() method to all the pets in
 * typeinfo.pets. Modify Apply.java to call the
 * sepack() method for a heterogeneous collection
 * of Pet.
 **/


class Spet extends Individual {
    public Spet(String name) {
        super(name);
    }

    public Spet() {
    }

    public void speak() {
        System.out.println(this + " speak");
    }
}

class SRodent extends Spet {
    public SRodent(String name) {
        super(name);
    }

    public SRodent() {
    }
}

class SRat extends SRodent {
    public SRat(String name) {
        super(name);
    }

    public SRat() {
    }
}

class SDog extends Spet {
    public SDog(String name) {
        super(name);
    }

    public SDog() {
    }
}

class SPug extends SDog {
    public SPug(String name) {
        super(name);
    }

    public SPug() {
    }
}

class SMutt extends SDog {
    public SMutt(String name) {
        super(name);
    }

    public SMutt() {
    }
}

class SMouse extends SRodent {
    public SMouse(String name) {
        super(name);
    }

    public SMouse() {
    }
}

class SCat extends Spet {
    public SCat(String name) {
        super(name);
    }

    public SCat() {
    }
}
class SManx extends SCat {
    public SManx(String name) {
        super(name);
    }

    public SManx() {
    }
}

class SHamster extends SRodent {
    public SHamster(String name) {
        super(name);
    }

    public SHamster() {
    }
}

class SEgyptianMau extends SCat{
    public SEgyptianMau(String name) {
        super(name);
    }

    public SEgyptianMau() {
    }
}

class Scymric extends SManx {
    public Scymric() {
    }

    public Scymric(String name) {
        super(name);
    }
}

public class E40_SpeakingPets {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Spet> pets = Arrays.asList(
                new SRat(),new SPug(),
                new SMutt(),new SMouse(),new SManx(),
                new SHamster(),new SEgyptianMau(),new Scymric()
        );
        Apply.apply(pets,Spet.class.getMethod("speak"));
    }
}
