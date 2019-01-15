package containers;

import net.mindview.util.TextFile;

import java.util.List;

/**
 * @author: liuHua
 * @create: 2019-01-15 11:01
 * Repeat Exercise 13 using a SlowMap
 **/
public class E15_WordCounter2 {
	public static void main(String[] args) {
		List<String> words = new TextFile("thinking_in_java/src/main/java/containers/E12_MapsDemo" +
				".java", "\\W+");
		SlowMap<String, Integer> map = new SlowMap<>();
		for (String word : words) {
			Integer freq = map.get(word);
			map.put(word, freq == null ? 1 : freq + 1);
		}
		System.out.println(map);
	}
}
