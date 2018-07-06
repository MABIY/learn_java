package generics1;


import generics1.util.Generator;

public class E14_BasicGeneratorDemo2 {
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);

    }
}
