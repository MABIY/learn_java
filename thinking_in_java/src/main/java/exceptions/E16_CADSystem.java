package exceptions;

import reusing.CADSystem;

/**
 * @author lh
 * Modify resuing/CADSystem.java to demonstrate
 * that returning from the middle of a try-finally
 * will still perform proper cleanup
 **/
public class E16_CADSystem {
    public static void main(String[] args) {
        reusing.CADSystem x = new CADSystem(47);
        try {
            return;
        }finally {
            x.dispose();
        }
    }
}
