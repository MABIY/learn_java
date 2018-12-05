package generics;

import generics.util.New;
import typeinfo.Person;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * @author: liuHua
 * @create: 2018-12-05 13:49
 **/

public class ExplicitTypeSpecification {
	
	static void f(Map<Person, List<Pet>> petPeople){}
	
	public static void main(String[] args) {
		f(New.<Person, List<Pet>>map());
	}
}
