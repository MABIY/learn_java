package generics.coffee;

import java.util.Iterator;

/**
 * @author: liuHua
 * @create: 2018-12-05 11:14
 * Use composition instead of inheritance to adapt
 * Fibonacci to make it Iterable
 **/

class IterableFibonacci7 implements Iterable<Integer>{
	private Fibonacci fib = new Fibonacci();
	private int n;
	
	public IterableFibonacci7(int count) {
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
				--n;
				return fib.next();
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove");
			}
		};
	}
}
public class E07_IterableFibonacci2 {
	public static void main(String[] args) {
		for (int i : new IterableFibonacci(18)) {
			System.out.print(i + " ");
		}
	}
}
