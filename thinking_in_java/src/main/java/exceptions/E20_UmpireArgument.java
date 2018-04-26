package exceptions;

class BaseballException20 extends Exception {
}

class Foul20 extends BaseballException20 {
}

class UmpireArguemnt20 extends BaseballException20 {
}

class Strike20 extends BaseballException20 {
}

class UmpireArgument extends BaseballException20 {
}

abstract class Inning20 {
    Inning20() throws BaseballException20 {
    }

    void event() throws BaseballException20 {
    }

    abstract void atBat() throws Strike20, Foul20, UmpireArguemnt20;

    abstract void decision() throws UmpireArguemnt20;

    void walk() {
    } // Throws nothing
}

class StormException20 extends Exception {
}

class RainedOut20 extends StormException20 {
}

class PopFoul20 extends Foul20 {
}

interface Storm20 {
    void event() throws RainedOut20;

    void rainHard20() throws RainedOut20;
}

class StormyInning20 extends Inning20 implements Storm {

    StormyInning20() throws RainedOut20,BaseballException20 {}
    StormyInning20(String s) throws Foul,BaseballException20 {}

    @Override
    public void event() {

    }

    @Override
    void atBat() throws Foul20, UmpireArguemnt20 {

    }

    @Override
    void decision() throws UmpireArguemnt20 {

    }

    @Override
    public void rainHard() throws RainedOut {
    }
}

public class E20_UmpireArgument {
    public static void main(String[] args) {
        // Same code as before,still catches
        // the new exception
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

        // Strike not thrown in derived version
        try {
            Inning20 i = new StormyInning20();
            i.atBat();
        } catch (Strike20 e) {
            System.out.println("Strike");
        } catch (Foul20 e) {
            System.out.println("Foul");
        } catch (RainedOut20 rainedOut) {
            System.out.println("Rained out");
        } catch (BaseballException20 e) {
            System.out.println("Generic baseball exception");
        }

        // Or you can add code to catch the
        // specific type of exception:
        try {
            StormyInning20 si = new StormyInning20();
            si.atBat();
            si.hashCode();
        } catch (PopFoul20 e) {
            System.out.println("Pop foul");
        } catch (RainedOut20 e) {
            System.out.println("Rained out");
        } catch (UmpireArguemnt20 e) {
            System.out.println("Argument with the umpire");
        } catch (BaseballException20 e) {
            System.out.println("Generic error");
        }
    }
}
