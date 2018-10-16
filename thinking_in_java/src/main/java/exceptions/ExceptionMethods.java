package exceptions;

import static access.util.Print.print;

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            print("Caught Exception");
            print("getMessage():" + e.getMessage());
            print("getLocalizedMessage():" + e.getLocalizedMessage());
            print("toString(): " + e);
            print("printStackTrac():");
            e.printStackTrace(System.out);
        }
    }
}
