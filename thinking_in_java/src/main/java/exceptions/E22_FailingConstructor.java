package exceptions;

import javax.security.auth.login.FailedLoginException;

/**
 * @author lh
 * Create a class called FailingConstructor with a
 * constructor that might fail partway throught the
 * construction process and throw an exception. In
 * main() write code that properly guards against
 * this failure
 **/
class ConstructionException22 extends Exception{}
class FailingConstructor{
    public FailingConstructor(boolean fail) throws ConstructionException22 {
        if (fail) {
            throw new ConstructionException22();
        }
    }
}
public class E22_FailingConstructor {
    public static void main(String[] args) {
        for (boolean b = false; ; b = !b) {
            try {
                System.out.println("Constructing... ");
                FailingConstructor fc = new FailingConstructor(b);
                try {
                    System.out.println("Processing... ");
                } finally {
                    System.out.println("Cleanup... ");
                }
            } catch (ConstructionException22 e) {
                System.out.println("Construction has failed: " + e);
                break;
            }
        }
    }
}
