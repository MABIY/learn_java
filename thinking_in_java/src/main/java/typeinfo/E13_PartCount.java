package typeinfo;

import net.lh.util.TypeCounter;

import static net.lh.util.Print.print;

/**
 * Use TypeCounter with the RegisteredFactories.java
 * example in this chapter.
 **/
public class E13_PartCount {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        Part part;
        for (int i = 0; i < 20; i++) {
            part = Part.createRandom();
            print(part.getClass().getSimpleName() + " ");
            counter.count(part);
        }
        print();
        print(counter);
    }
}
