package typeinfo;

import typeinfo.pets.*;
import typeinfo.pets1.Gerbil;

import java.util.HashMap;

import static net.lh.util.Print.print;

/**
 * @author lh
 **/
public class PetCount {
    static class PetCounter extends HashMap<String,Integer>{
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
           // List each individual pet:
            print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                counter.count("Pet");
            }
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
            }
            if (pet instanceof Pug) {
                counter.count("Pug");
            }
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
            if (pet instanceof EgyptianMau) {
                counter.count("EgyptianMau");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
            }
            if (pet instanceof Cymric) {
                counter.count("Cymric");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
            }
            if (pet instanceof Gerbil) {
                counter.count("Gerbil");
            }
        }
        // Show the counts:
        print();
        print(counter);
    }

    public static void main(String[] args) {
        countPets(new typeinfo.pets1.ForNameCreator());
    }

}
