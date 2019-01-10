package containers;

import net.mindview.util.TextFile;

import java.util.List;

/**
 * @author: liuHua
 * @create: 2019-01-10 13:47
 **/

class AssociativeArray13<K,V>{
	private Object[][] pairs;
	private int index;
	
	public AssociativeArray13(int length) {
		pairs = new Object[length][2];
	}
	
	public void put(K key, V value) {
		for (int i = 0; i < index; i++) {
			if (key.equals(pairs[i][0])) {
				pairs[i] = new Object[]{key, value};
				return;
			}
		}
		
		if (index >= pairs.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		pairs[index++] = new Object[]{key, value};
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		for (int i = 0; i < index; i++) {
			if (key.equals(pairs[i][0])) {
				return (V) pairs[i][1];
			}
		}
		return null;
	}
}
public class E13_WordCounter {
	public static void main(String[] args) {
		List<String> words = new TextFile("thinking_in_java/src/main/java/containers/E13_WordCounter.java", "\\W+");
		AssociativeArray<String, Integer> map = new AssociativeArray<>(words.size());
		for (String word : words) {
			Integer freq = map.get(word);
			map.put(word, freq == null ? 1 : freq + 1);
		}
		System.out.println(map);
	}
}
