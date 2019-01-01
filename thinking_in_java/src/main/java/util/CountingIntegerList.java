package util;

import java.util.AbstractList;

/**
 * @author: liuHua
 * @create: 2019-01-01 16:03
 **/

public class CountingIntegerList extends AbstractList<Integer> {
	private int size;
	
	public CountingIntegerList(int size) {
		this.size = size < 0 ? 0 : size;
	}
	
	@Override
	public Integer get(int index) {
		return index;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		System.out.println(new CountingIntegerList(30));
	}
}
