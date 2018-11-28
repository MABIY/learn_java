package holding;

import typeinfo1.pets.Pet;
import typeinfo1.pets.Pets;

import java.util.Iterator;
import java.util.List;

public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();

        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
        // A simple approach, when possible:
        for (Pet p : pets) {
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
        // An Iterator can also remove elements:
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            Pet pet = it.next();
        }
        System.out.println(pets);
    }
}
