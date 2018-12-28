package arrays;

import java.util.*;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-28 17:20
 **/
public class E25_PythonLists {
	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		print(aList.getClass().getSimpleName());
		print(aList);
		aList.add(6);
		aList.addAll(Arrays.asList(7, 8));
		print(aList);
		class MyArrayList<T> extends ArrayList<T>{
			MyArrayList(Collection<? extends T> c) {
				super(c);
			}
			
			MyArrayList(int initialCapacity) {
				super(initialCapacity);
			}
			
			List<T> getReversed() {
				List<T> reversed = new ArrayList<>(size());
				ListIterator<T> it = listIterator(size());
				while (it.hasPrevious()) {
					reversed.add(it.previous());
				}
				return reversed;
			}
		}
		
		MyArrayList<Integer> list2 = new MyArrayList<>(aList);
		print(list2.getClass().getSimpleName());
		print(list2.getReversed());
	}
}
