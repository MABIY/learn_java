package containers;

import generics.util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author: liuHua
 * @create: 2019-01-09 14:10
 **/

public class QueueBehavior {
	private static int count = 10;
	
	static <T> void test(Queue<T> queue, Generator<T> gen) {
		for (int i = 0; i < count; i++) {
			queue.offer(gen.next());
		}
		while (queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		test(new LinkedList<>(), new Gen());
		test(new PriorityQueue<>(), new Gen());
		test(new ArrayBlockingQueue<>(count), new Gen());
		test(new ConcurrentLinkedDeque<>(), new Gen());
		test(new LinkedBlockingDeque<>(), new Gen());
		test(new PriorityBlockingQueue<>(),new Gen());
		
	}
	
	static class Gen implements Generator<String> {
		String[] s = ("one two three four five six seven " + "eight nine ten").split(" ");
		
		int i;
		
		@Override
		public String next() {
			return s[i++];
		}
	}
}
