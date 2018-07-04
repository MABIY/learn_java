package generics1;

import typeinfo1.pets.Mouse;
import typeinfo1.pets.Pet;

public class E01_PetsHolder {
    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<>(new Mouse("Mickey"));
        System.out.println(h3.get());
    }
}
