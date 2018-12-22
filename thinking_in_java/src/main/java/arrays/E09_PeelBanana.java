package arrays;

import java.util.ArrayList;

/**
 * @author: liuHua
 * @create: 2018-12-22 21:36
 **/
class Banana{
	private final int id;
	
	public Banana(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}

class Peel<T>{
	T fruit;
	
	public Peel(T fruit) {
		this.fruit = fruit;
	}
	
	void peel(){
		System.out.println("Peeling " + fruit);
	}
}
public class E09_PeelBanana {
	public static void main(String[] args) {
		//compile error:
		// Peel<Banana>[] a = new Peel<Banana>[10];
		ArrayList<Peel<Banana>> a = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			a.add(new Peel<>(new Banana(i)));
		}
		for (Peel<Banana> p : a) {
			p.peel();
		}
	}
}
