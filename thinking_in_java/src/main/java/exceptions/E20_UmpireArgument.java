package exceptions;

/**
 * @author lh
 * Modify StorymyInning.java by adding an
 * UmpireArguemnt exception type and methods
 * that throw this exception. Test teh modified
 * hierarchy
 **/
class BaseballException20 extends Exception{}
class Foul20 extends BaseballException20{}
class Strike20 extends BaseballException20{}
class UmpireArgument20 extends BaseballException20{}
abstract class Inning20{
    public Inning20() throws BaseballException20{
    }
    void event() throws BaseballException20{}
    abstract void atBat() throws Strike20,Foul20, UmpireArgument20;

    abstract void decision() throws UmpireArgument20;

    void walk(){} //Throws nothing

}

class StormException20 extends Exception{}
class RainedOut20 extends StormException{}
class PopFoul20 extends Foul20{}

interface Storm20{
    public void event() throws RainedOut20;

    public void rainHard() throws RainedOut20;
}

class StormyInning20 extends Inning20 implements Storm20 {
    public StormyInning20() throws BaseballException20,RainedOut20 {
    }

    StormyInning20(String s) throws Foul20,BaseballException20{}

    @Override
    void atBat() throws PopFoul20, UmpireArgument20 {
        throw new UmpireArgument20();
    }

    @Override
    void decision() throws UmpireArgument20 {
        throw new UmpireArgument20();
    }

    @Override
    public void event() {

    }

    @Override
    public void rainHard() throws RainedOut20 {

    }
}
public class E20_UmpireArgument {
    public static void main(String[] args) {
        //Same code as before, still catches the new exception:
        try {
            StormyInning20 si = new StormyInning20();
            si.atBat();
        } catch (PopFoul20 e) {
            System.out.println("Pop foul");
        } catch (RainedOut20 e) {
            System.out.println("Rained out");
        } catch (BaseballException20 e) {
            System.out.println("Generic error");
        }
        //Strike20 not thrown in derived version.
        try {
            Inning20 i = new StormyInning20();
            i.atBat();
        } catch (Strike20 e) {
            System.out.println("Strike");
        } catch (Foul20 e) {
            System.out.println("Foul");
        } catch (RainedOut20 e) {
            System.out.println("Rained out");
        } catch (BaseballException20 e) {
            System.out.println("Generic baseball exception");
        }
        // Or you can add code to catch the
        // specific type of exception:
        try {
            StormyInning20 si = new StormyInning20();
            si.atBat();
            si.decision();
        } catch (PopFoul20 e) {
            System.out.println("Pop foul");
        } catch (RainedOut20 e) {
            System.out.println("Rained out");
        } catch (UmpireArgument20 e) {
            System.out.println("Argument with the umpire");
        } catch (BaseballException20 e) {
            System.out.println("Generic error");
        }
    }
}
