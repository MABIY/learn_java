package holding;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * @author lh
 * Take the resulting Map from the previous
 * exercise and recreate the order of the words
 * as they appeared in the original file.
 **/
public class E26_WordsInfo4 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> stat = new HashMap<>();
        int wordCount = 0;
        List<String> origWords = new TextFile("thinking_in_java/src/main/java/holding/E26_WordsInfo4.java", "\\W+");
        for (String word : origWords) {
            ArrayList<Integer> loc = stat.get(word);
            if (loc == null) {
                loc = new ArrayList<>();
                stat.put(word, loc);
            }
            loc.add(++wordCount);
        }
        // Now recreate the original order of words.
        // We will use an inverted structured, where the key
        // is the position of the word in the file. Also,
        // we will sort words based on their positions
        TreeMap<Integer, String> words = new TreeMap<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : stat.entrySet()) {
            for (Integer pos : entry.getValue()) {
                words.put(pos, entry.getKey());
            }
        }
        // Test the correctness.
        System.out.println(origWords);
        System.out.println(words.values());
    }
}