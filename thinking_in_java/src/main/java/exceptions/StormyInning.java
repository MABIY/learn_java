package exceptions;

import reusing.E;

/**
 * @author lh
 * Overridden methods may throw only the exceptions
 * specified in their base-class versions. or exceptions
 * derived from teh base-class exceptions
 **/
class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}
abstract class Inning{
    public Inning() throws BaseballException{}
    public void event() throws BaseballException{
        // Doesn't actually have to throw anything
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {} // Throw no checked exceptions
}

class StormException extends Exception {}
class RainedOut extends StormException{}
class PopFoul extends Foul{}
interface Storm{
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}
public class StormyInning extends Inning implements Storm{
    //  ok to add new exception for constructors, but you
    // must deal with the base constructor exceptions.
    public StormyInning() throws BaseballException,RainedOut {
    }
    public StormyInning(String s) throws BaseballException,Foul {
    }
    // reqular methods must conform to base class.
    // public void walk() throws PopFoul{} // Compiler error
    // interface CANNOT add exceptions to existing methods from the base class.
    // public void event() throws RainedOut{}
    // If the method doesn't already exist in the
    // base class, the exception is ok:
    @Override
    public void rainHard() throws RainedOut {
    }
    // You can choose to not throw any exceptions
    // even if the base version does:
    @Override
    public void event() {
    }

    // Overridden methods can throw inherited exceptions
    @Override
    public void atBat() throws PopFoul{}

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
        // Strike not thrown in  derived version.
        try {
            // What happens if you upcase?
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
