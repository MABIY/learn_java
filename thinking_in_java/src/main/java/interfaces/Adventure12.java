package interfaces;

/**
 * @author lh
 * In Adventure.java,add an interface called CanClimb,following
 * the form of the other interface.
 **/
interface CanFight12{
    void fight();
}

interface CanSwim12{
    void swim();
}
interface CanFly12{
    void fly();
}

interface CanClimb12{
    void climb();
}

class ActionCharacter12{
    public void fight() {

    }
}

class Hero12 extends ActionCharacter12 implements CanFight12,CanSwim12,CanFly12,CanClimb12{

    @Override
    public void swim() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void climb() {

    }
}
public class Adventure12 {
    public static void t(CanFight12 x) {
        x.fight();
    }

    public static void u(CanSwim12 x) {
        x.swim();
    }

    public static void v(CanFly12 x) {
        x.fly();
    }

    public static void c(CanClimb12 x) {
        x.climb();
    }

    public static void w(ActionCharacter12 x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero12 h = new Hero12();
        t(h); // treat it as a CanFight
        u(h); // treat it as a CanSwim
        v(h); // treat it as a Canfly
        c(h); // treat it as a Canclimb
        w(h); // treat it as a ActionCharacter
    }
}
