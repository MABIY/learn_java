package typeinfo;

import typeinfo.pets.Pet;
import typeinfo.util.TypeCounter;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author: liuHua
 * @create: 2018-11-30 13:41
 **/

public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : Pets.createArray(20)) {
			printnb(pet.getClass());
			counter.count(pet);
		}
		print();
		print(counter);
	}
}
