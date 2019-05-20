package typeinfo;

import net.lh.util.TypeCounter;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import static net.mindview.util.Print.print;

/**
 * @author lh
 **/
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        print();
        print(counter);
    }
}
