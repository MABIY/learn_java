package exceptions;

public class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException1");
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException2");
        }finally {
            sw.off();
        }
    }
}
