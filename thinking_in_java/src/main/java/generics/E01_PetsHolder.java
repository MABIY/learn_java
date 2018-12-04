package generics;

import typeinfo.pets.Mouse;
import typeinfo.pets.Pet;

/**
 * @author: liuHua
 * @create: 2018-12-04 13:41
 * Use Holder3 with the typeinfo.pets library to
 * show that a Holder3 that is specified to hold
 * a base type can also hold a derived type
 **/

public class E01_PetsHolder {
	public static void main(String[] args) {
		Holder3<Pet> h3 = new Holder3<>(new Mouse("Mickey"));
		System.out.println(h3.getA());
	}
}
