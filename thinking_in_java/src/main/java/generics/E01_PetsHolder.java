package generics;

import typeinfo.pets.Mouse;
import typeinfo.pets.Pet;

/**
 * @author lh
 * Use Holder3 with the typeinfo.pets library to
 * show that a Hlder3 that is specificed to hold
 * a base type can also hold a derived type.
 **/
public class E01_PetsHolder {
    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<>(new Mouse("Mickey"));
        System.out.println(h3.get());
    }
}
