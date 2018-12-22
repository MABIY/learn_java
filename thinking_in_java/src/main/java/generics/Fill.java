package generics;

import initialization.ConstructorTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Generalizing the FilledList idea
 * @author: liuHua
 * @create: 2018-12-20 14:02
 **/
// Doesn't work with "anything that has an add()." There is
	// no "Addable" interface so we are narrowed to using a
	// Collection. we cannot generalize using generics in
	// this class
public class Fill {
	public static <T> void fill(Collection<T> collection, Class<? extends T> classToken, int size) {
		for (int i = 0; i < size; i++) {
			// Assumes default constructor:
			try {
				collection.add(classToken.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class Contract{
	private static long counter = 0;
	private final long id = counter++;
	
	@Override
	public String toString() {
		return getClass().getName() + " " + id;
	}
}

class TitleTransfer extends Contract{}

class FillTest{
	public static void main(String[] args) {
		List<Contract> contracts = new ArrayList<>();
		Fill.fill(contracts, Contract.class, 3);
		Fill.fill(contracts, TitleTransfer.class, 2);
		for (Contract c : contracts) {
			System.out.println(c);
		}
		
		SimpleQueue<Contract> contractQueue = new SimpleQueue<>();
		// Won't work. fill() is not generic enough:
		// Fill.fill(contractQueue, Contract.class, 3);
	}
}
