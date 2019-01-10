package containers;

import util.Deque;

import static access.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author: liuHua
 * @create: 2019-01-10 13:15
 **/

public class DequeTest {
	static void fillTest(Deque<Integer> deque) {
		for (int i = 20; i < 27; i++) {
			deque.addFirst(i);
		}
		for (int i = 50; i < 55; i++) {
			deque.addLast(i);
		}
	}
	
	public static void main(String[] args) {
		Deque<Integer> di = new Deque<>();
		fillTest(di);
		print(di);
		while (di.size() != 0) {
			printnb(di.removeFirst()+" ");
		}
		print();
		fillTest(di);
		while (di.size() != 0) {
			printnb(di.removeLast()+" ");
		}
	}
}
