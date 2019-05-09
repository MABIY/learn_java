package holding;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * @author lh
 * Using a Map<String,Integer>,follow the form of
 * UniqueWords.java to create a program that counts
 * the occurrence of words in a file. Sort the
 * results using Collection.sort() with a second
 * arguemtn of String.CASE_INSENSITIVE_ORDER (to
 * produce an alphabetic sort), and display the reuslt.
 **/
public class E21_WordInfo {
    public static void main(String[] args) {
        Map<String, Integer> wordStat = new HashMap<>();
        for (String word : new TextFile("thinking_in_java/src/main/java/holding/E21_WordInfo.java","\\W+")) {
            Integer freq = wordStat.get(word);
            wordStat.put(word, freq == null ? 1 : freq + 1);
        }
        List<String> keys = new ArrayList<>(wordStat.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (String key : keys) {
            System.out.println(key  + " => " + wordStat.get(key));
        }
    }
}
