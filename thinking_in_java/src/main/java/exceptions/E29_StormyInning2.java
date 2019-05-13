package exceptions;

/**
 * @author lh
 * Modify all the exception types in StorymyInning.java
 * so that they extend RuntimeException, and show
 * that no exception specifications or try block are
 * necessary . Remove the '//!' comments and show how
 * the method can be compiled without specifications
 **/
class BaseballException2 extends RuntimeException {
}
class Foul2 extends BaseballException2{}

class Strike2 extends BaseballException2 {
}

abstract class Inning2{
    public Inning2() {
    }
    public void event(){}
    abstract void atBat();
    void walk(){}
}
class StormException2 extends RuntimeException{}
class RainedOut2 extends StormException2{}
class PopFoul2 extends Foul2{}
interface Storm2{
    void event();

    void rainHard();
}
class StorymyInning2 extends Inning2 implements Storm2{
    public StorymyInning2() {
    }

    public StorymyInning2(String s) {
    }

    @Override
    void atBat() {
        throw new PopFoul2();
    }

    @Override
    public void rainHard() {
    }
}
public class E29_StormyInning2 {
    public static void main(String[] args) {
        StorymyInning2 si = new StorymyInning2();
        si.atBat();
    }
}
