package exceptions;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Finally is always executed
 **/
class FourException extends Exception{}
public class AlwaysFinally {
    public static void main(String[] args) {
        print("Entering first try block");
        try {
            print("Entering second try block");
            try {
                throw new FourException();
            } finally {
                print("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in lst try block");
        }finally {
            System.out.println("finally in lst try block");
        }
    }
}
