package containers;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author: liuHua
 * @create: 2019-01-09 16:05
 **/
class Item implements Comparable<Item>{
	private static final Random rnd = new Random(47);
	private Integer priority = rnd.nextInt(101);
	@Override
	public int compareTo(Item o) {
		return Integer.compare(priority, o.priority);
	}
	
	@Override
	public String toString() {
		return Integer.toString(priority);
	}
}
public class E11_PriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Item> queue = new PriorityQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.add(new Item());
		}
		Item item;
		while ((item = queue.poll()) != null) {
			System.out.println(item);
		}
	}
}
