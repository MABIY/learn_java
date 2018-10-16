package exceptions;

import reusing.E;

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
        //Doesn't actually have to thrown anything
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() { // Throws no checked exceptions
    }
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
     void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

public class StormyInning  extends Inning implements Storm{
    // Ok to add new exception for constructor , but you must
    // deal with the base constructor exceptions:
    public StormyInning() throws BaseballException,RainedOut {
    }

    public StormyInning(String s) throws Foul, BaseballException {
    }

    //Regular methods must conform to base class:
    // @Override
    // public void walk() throws PopFoul{
    //     super.walk();
    // }

    // if the method doesn't already exist in the
    // base class, the exception is OK:
    @Override
    public void rainHard() throws RainedOut {
    }

    // You can choose to not throw any exceptions,
    // even if the base version does:
    @Override
    public void event() {
    }

    // Interface CANNOT addd exceptions to existing
    // methods from the base class:
    // @Override
    // public void event() throws RainedOut{

    // }

    //Overridden methods  can thrown inherited exception
    @Override
    public void atBat() throws  PopFoul {
    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Gerneric baseball exception");
        }
        // Strike not thrown in derived version.
        try {
            // What happens if you upcast ?
            Inning i = new StormyInning();
            i.atBat();
            /*
            You must catch the exceptions from the
            base-class
            */
        } catch (Strike strike) {
            strike.printStackTrace();
        } catch (Foul foul) {
            foul.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        }
    }
}
