package typeinfo;

import typeinfo.pets.Pet;
import typeinfo.pets.LiteralPetCreator;
import typeinfo.pets.PetCreator;

import java.util.ArrayList;

/**
 * @author: liuHua
 * @create: 2018-11-30 11:46
 **/

public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();
	public static Pet randomPet() {
		return creator.randomPet();
	}
	
	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}
	
	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}
}
