package generics;

import typeinfo.pets.Cymric;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify Fill2.java to use the classe in
 * typeinfo.pets instead of the Coffee classes
 **/
public class E41_Fill3 {
    public static void main(String[] args) {
        // Adapt a Collection:
        List<Pet> carrier = new ArrayList<>();
        Fill2.fill(
                new AddableCollectionAdapter<>(carrier), Pet.class, 3
        );
        // Helper method captures the type:
        Fill2.fill(Adapter.colllectionAdapter(carrier), Mouse.class, 2);
        for (Pet p : carrier) {
            print(p);
        }
        print("----------");
        // Use an ada[ted class:
        AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<>();
        Fill2.fill(petQueue, Mutt.class, 4);
        Fill2.fill(petQueue, Cymric.class, 1);
        for (Pet p : petQueue) {
            print(p);
        }
    }
}
