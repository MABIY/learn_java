package exceptions;

/**
 * @author lh
 * Catching exception hierarchies
 **/
class Anonyance extends Exception{}
class Sneeze extends Anonyance{}

public class Human {
    public static void main(String[] args) {
        // Catch the exact type:
        try {
            throw new Sneeze();
        } catch (Sneeze sneeze) {
            System.out.println("Caught Sneeze");
        } catch (Anonyance a) {
            System.out.println("Caught Anonyance");
        }
        // Catch the base type:
        try {
            throw new Sneeze();
        } catch (Anonyance a) {
            System.out.println("Caught Anonyance");
        }
    }
}
