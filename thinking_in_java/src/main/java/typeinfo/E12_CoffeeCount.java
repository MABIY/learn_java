package typeinfo;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;
import net.lh.util.TypeCounter;

import java.util.Iterator;

import static net.lh.util.Print.print;

/**
 * Use typeCounter with the CoffeeGenerator.java
 *
 **/
public class E12_CoffeeCount {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Coffee.class);
        for (Iterator<Coffee> it = new CoffeeGenerator(20).iterator(); it.hasNext();) {
            Coffee coffee = it.next();
            print(coffee.getClass().getSimpleName() + " ");
            counter.count(coffee);
        }
        print();
        print(counter);
    }
}
