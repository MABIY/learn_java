package containers;

import net.mindview.util.TextFile;

import java.util.List;

/**
 * @author lh
 * Repeat Exercise 13 using a SimpleHashMap
 **/
public class E19_WordCounter3 {
    public static void main(String[] args) {
        List<String> words = new TextFile("thinking_in_java/src/main/java/containers/E12_MapsDemo.java", "\\W+");
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        for (String word : words) {
            Integer freq = map.get(word);
            map.put(word, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
