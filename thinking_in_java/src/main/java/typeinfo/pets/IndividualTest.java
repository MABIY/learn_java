package typeinfo.pets;

import holding.MapOfList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author lh
 **/
public class IndividualTest {
    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<>();
        for (List<? extends Pet> lp : MapOfList.petPeople.values()) {
            for (Pet p : lp) {
                pets.add(p);
            }
        }
        System.out.println(pets);
    }
}
