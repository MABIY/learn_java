package typeinfo1;

import net.mindview.util.MapData;
import typeinfo1.pets.LiteralPetCreator;
import typeinfo1.pets.Pet;
import typeinfo1.pets.Pets;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }

        public void count(Pet pet) {
            // Class.isInstance() eliminates instanceofs:
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet)) {
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }

            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }

        public static void main(String[] args) {
            PetCounter petCounter = new PetCounter();
            for (Pet pet : Pets.createArray(20)) {
                System.out.println(pet.getClass().getSimpleName() + " ");
                petCounter.count(pet);
            }
            System.out.println();
            System.out.println(petCounter);
        }
    }
}