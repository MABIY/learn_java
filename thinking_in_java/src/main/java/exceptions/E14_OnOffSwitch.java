package exceptions;

import sun.plugin.net.protocol.jar.CachedJarURLConnection;

public class E14_OnOffSwitch {
    static Switch sw = new Switch();
    static void f() throws OnOffException1,OnOffException2{
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            try {
                sw.on();
                // Code that can throw exceptions...
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
            System.out.println("Oops! the exception '" +
                    e + "' slipped through without" +
                    "turning the switch off!");
        }
    }
}
