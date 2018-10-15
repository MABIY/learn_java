package exceptions;

public class E02_NullReference {
    public static void main(String[] args) {
        String s = null;
        // Causes  a NullPointerException
        //! s.toString();
        try {
            s.toString();
        } catch (Exception e) {
            System.out.println("Caught exception " + e);
        }
    }
}
