package generics;

import typeinfo.pets.Cymric;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-22 11:04
 * Modify Fill2.java to use the classes in
 * typeinof.pets instead of the Coffee classes
 **/

public class E41_Fill3 {
	public static void main(String[] args) {
		// Adapt a Collection:
		List<Pet> carrier = new ArrayList<>();
		Fill2.fill(
				new AddableColllectionAdapter<>(carrier), Pet.class, 3
		);
		
		//Helper method captures the type
		Fill2.fill(Adapter.collectionAdapter(carrier), Mouse.class,2);
		for (Pet p :
				carrier) {
			print(p);
		}
		
		print("----------");
		// Use a adapted class:
		AddableSimpleQueue<Pet> petQueuer = new AddableSimpleQueue<>();
		Fill2.fill(petQueuer, Mutt.class, 4);
		Fill2.fill(petQueuer, Cymric.class,1);
		for (Pet p : petQueuer) {
			print(p);
		}
		
	}
}
