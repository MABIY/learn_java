package generics;

import generics.util.New;
import typeinfo.Person;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * @author: liuHua
 * @create: 2018-12-05 13:40
 **/

public class LimitsOfInference {
	static void f(Map<Person, List<? extends Pet>> petPeople) {
	
	}
	
	public static void main(String[] args) {
		f(New.map());
	}
}
