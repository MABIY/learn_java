package exceptions;

class ThreeException extends Exception {}
public class FinallyWords {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                // Post-increment is zero first time:
                if (count++ == 0) {
                    throw new ThreeException();
                }
            } catch (ThreeException e) {
                System.out.println("TreeException");
            }finally {
                System.out.println("In finally clause");
                if (count == 2) {
                    break; // Out of "while"
                }
            }
        }
    }
}
