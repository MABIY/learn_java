package exceptions;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Demonstrating the Exception Mehtods
 **/
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            print("Caught Exception");
            print("getMessage():" + e.getMessage());
            print("getLocalizedMessage():" + e.getLocalizedMessage());
            print("toString(): " + e);
            print("PrintStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }
}
