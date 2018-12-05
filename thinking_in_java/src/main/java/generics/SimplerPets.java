package generics;

import generics.util.New;
import typeinfo.Person;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * @author: liuHua
 * @create: 2018-12-05 13:37
 **/

public class SimplerPets {
	public static void main(String[] args) {
		Map<Person, List<? extends Pet>> petPeople = New.map();
		// Rest of the code is the same....
	}
}
