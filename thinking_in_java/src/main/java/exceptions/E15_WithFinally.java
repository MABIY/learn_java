package exceptions;

/**
 * @author lh
 * Show that WithFinally.java doesn't fail by
 * throwing a RuntimeException inside the try
 * block
 **/
public class E15_WithFinally {
    static Switch sw = new Switch();

    static void f() throws OnOffException1,OnOffException2{
        throw new RuntimeException("Inside try");
    }

    public static void main(String[] args) {
        try {
            try {
                sw.on();
                // Code that can throw exceptions...
                f();
            } catch (OnOffException2 onOffException2) {
                System.out.println("OnOffException2");
            } catch (OnOffException1 onOffException1) {
                System.out.println("OnOffException1");
            } finally {
                sw.off();
            }
        } catch (RuntimeException e) {
            System.out.println("Exception '" +
                    "'. Did the switch get turned off ?");
            System.out.println(sw);
        }
    }
}
