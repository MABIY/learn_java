package holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * @author lh
 **/
public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() +":" + p + " ");
        }
        System.out.println();
        // A simple approach. When possible::
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
}
