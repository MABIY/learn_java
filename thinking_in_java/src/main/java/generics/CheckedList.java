package generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-17 14:00
 * Using Collection.checkedList()
 **/
public class CheckedList {
	static void oldSytleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
	}
	
	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<>();
		oldSytleMethod(dogs1);//Quitely accepts a Cat
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);
		try {
			oldSytleMethod(dogs2); // Throws an exception
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Derived types work fine:
		List<Pet> pets = Collections.checkedList(
				new ArrayList<>(), Pet.class
		);
		
		pets.add(new Dog());
		pets.add(new Cat());
	}
}
