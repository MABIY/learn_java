package generics;

/**
 * @author: liuHua
 * @create: 2018-12-04 15:03
 * Remove the type parameter on the Node class and
 * modify the rst of the code in LinkedStack.java
 * to show that an inner class has access to the
 * generic type
 **/

class LinkedStack5<T> {
	private class Node{
		T item;
		Node next;
		Node() {
			item = null;
			next = null;
		}
		
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
		
		boolean end() {
			return item == null && next == null;
		}
	}
	
	private Node top = new Node(); // End sentinel
	
	public void push(T item) {
		top = new Node(item, top);
	}
	
	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}
}
public class E05_LinkedStack2 {
	public static void main(String[] args) {
		LinkedStack5<String> lss = new LinkedStack5<>();
		for (String s : "Phasers on stun!".split(" ")) {
			lss.push(s);
		}
		
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}
	}
}