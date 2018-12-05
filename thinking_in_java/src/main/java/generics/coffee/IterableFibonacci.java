package generics.coffee;

import java.util.Iterator;

/**
 * @author: liuHua
 * @create: 2018-12-05 11:10
 * Adapt the Fibonacci class make it Iterable.
 **/

public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
	
	private int n;
	
	public IterableFibonacci(int count) {
		this.n = count;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return n > 0;
			}
			
			@Override
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}
		};
	}
	
	public static void main(String[] args) {
		for (int i : new IterableFibonacci(10)) {
			System.out.print(i + " ");
		}
	}
}
