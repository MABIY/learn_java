package containers;

import holding.MapOfList;
import typeinfo1.pets.Individual;
import typeinfo1.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: liuHua
 * @create: 2019-01-20 13:21
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
