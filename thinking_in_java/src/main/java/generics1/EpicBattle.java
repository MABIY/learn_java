package generics1;

import java.util.List;

interface SuperPower{}

interface XRayVision extends SuperPower{
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower{
    void hearSubtleNoises();
}

class SuperHero<POWER extends SuperPower>{
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower() {
        return power;
    }
}


interface SuperSmell extends SuperPower{
    void trackBySmell();
}
class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER>{
    public SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER>{
    public CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}

class SuperHearSmell implements SuperHearing, SuperSmell{

    @Override
    public void hearSubtleNoises() {

    }

    @Override
    public void trackBySmell() {

    }
}

class DogBoy extends CanineHero<SuperHearSmell> {
    public DogBoy() {
        super(new SuperHearSmell());
    }
}
public class EpicBattle {
    // Bounds in generic methods:
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        // you cna do this:
        List<? extends SuperHearing> audioBoys;
        // But you can't do this:
        //List<? extends SuperHearing & SuperSmell> dogBoy;

    }
}
