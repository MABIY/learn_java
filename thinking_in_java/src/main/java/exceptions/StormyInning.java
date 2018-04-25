package exceptions;

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
        // Doesn't actually have to throw anything
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    } // Throws no checked exception

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

public class StormyInning extends Inning implements Storm {

    public StormyInning() throws RainedOut, BaseballException {
    }

    public StormyInning(String s) throws Foul, BaseballException {
    }

    // Regular methods must conform to base class;
//    void walk() throws PopFoul {
//
//    }

    // If the method doesn't already exist in the
    // base class, the exception is ok
//    public void event() throws RainedOut {
//
//    }

    @Override
    public void atBat() throws PopFoul {
    }

    @Override
    public void rainHard() throws RainedOut {
    }

    public void event() {
    }
    //Overrridden methods can throw inherited exception:

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        // Strike not thrown in derived version.
        try {
            // What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            // You must catch the exceptions from the
            // base-class version of the method:
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

    }
}

