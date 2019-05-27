package net.lh.util;

/**
 * @author lh
 * Modify BasicGeneratorDemo.java to use the e
 * explicit form of creation for the Generator
 * (that is, use the explicit constructor instead
 * of the generic create() method).
 **/
public class E14_BaseicGeneratorDemo2 {
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

    }
}
