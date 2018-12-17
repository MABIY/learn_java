package generics;

import generics.coffee.Americano;
import generics.coffee.Breve;
import generics.coffee.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-17 14:40
 * Modify CheckedList.java so that it uses the Coffee classes defined in this chapter.
 **/
public class E35_CheckedList2 {
	static void oldStyleMethod(List probablyAmericanos) {
		probablyAmericanos.add(new Breve());
	}
	
	public static void main(String[] args) {
		List<Americano> am1 = new ArrayList<>();
		oldStyleMethod(am1); //Quietly accepts a Breve
		List<Americano> am2 = Collections.checkedList(
				new ArrayList<>(), Americano.class
		);
		
		try {
			oldStyleMethod(am2); //Throws an exception
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Derived types work find:
		List<Coffee> coffees = Collections.checkedList(
				new ArrayList<>(), Coffee.class
		);
		coffees.add(new Americano());
		coffees.add(new Breve());
	}
}


