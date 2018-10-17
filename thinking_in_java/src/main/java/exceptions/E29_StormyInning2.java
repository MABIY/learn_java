package exceptions;

class BaseballException2 extends RuntimeException {

}

class Foul2 extends BaseballException2 {
}

class Strike2 extends BaseballException2{}

abstract class Inning2 {
    public Inning2() {
    }

    public void event() {

    }

    abstract void atBat();

    void walk() {

    }
}

class StormException2 extends RuntimeException{}
class RainedOut2 extends StormException2{}

class PopFoul2 extends Foul2 {
}

interface Storm2 {
    void event();

    void rainHard();
}


class StormyInning2 extends Inning2 implements Storm2 {


    public StormyInning2() {
    }

    public StormyInning2(String s) {
    }

    @Override
    void atBat() {

    }

    @Override
    public void rainHard() {

    }
}
public class E29_StormyInning2 {
    public static void main(String[] args) {
        StormyInning2 si = new StormyInning2();
        si.atBat();
    }
}
