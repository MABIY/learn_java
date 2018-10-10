package holding;

import net.mindview.util.TextFile;

import java.util.*;

public class E21_WordsInfo {
    public static void main(String[] args) {
        Map<String, Integer> wordsStat = new HashMap<>();
        for (String word : new TextFile("/data/project/learn_java/thinking_in_java/src/main/java/holding/E21_WordsInfo.java", "\\W+")) {
            Integer freq = wordsStat.get(word);
            wordsStat.put(word, freq == null ? 1 : freq + 1);
        }
        List<String> keys = new ArrayList<>(wordsStat.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (String key : keys) {
            System.out.println(key + " => " + wordsStat.get(key));
        }
    }
}
