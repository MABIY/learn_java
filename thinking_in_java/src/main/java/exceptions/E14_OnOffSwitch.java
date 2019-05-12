package exceptions;

/**
 * @author lh
 * Show that OnOffSwith.java can fail by
 * throwning a RuntimeException inside the try
 * block
 **/
public class E14_OnOffSwitch {
    static Switch sw = new Switch();

    static void f() throws OnOffException2,OnOffException1{
        throw new RuntimeException("Inside try");
    }

    public static void main(String[] args) {
        try {
            try {
                sw.on();
                // Code that can thrown exceptions...
                f();
                sw.off();
            } catch (OnOffException2 onOffException2) {
                System.out.println("OnOffException2");
                sw.off();
            } catch (OnOffException1 onOffException1) {
                System.out.println("OnOffException1");
                sw.off();
            }
        } catch (RuntimeException e) {
            System.out.println(sw);
            System.out.println("Oops! the exception '"
            + e + "' slipped throught without" +
                    "turning the switch off!1");
        }
    }
}
