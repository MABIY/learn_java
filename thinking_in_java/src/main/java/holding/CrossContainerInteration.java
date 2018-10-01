package holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.*;

public class CrossContainerInteration {
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" +p +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsH5 = new HashSet<>(pets);
        TreeSet<Pet> petsT5 = new TreeSet<>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsH5.iterator());
        display(petsT5.iterator());
    }
}
