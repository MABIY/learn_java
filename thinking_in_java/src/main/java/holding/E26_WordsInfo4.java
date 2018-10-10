package holding;

import net.mindview.util.TextFile;

import java.util.*;

public class E26_WordsInfo4 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> stat =
                new HashMap<>();

        int wordCount = 0;
        List<String> origWords = new TextFile("/data/project/learn_java/thinking_in_java/src/main/java/holding/E26_WordsInfo4.java", "\\W+");
        for (String word : origWords) {
            ArrayList<Integer> loc = stat.get(word);
            if (loc == null) {
                loc = new ArrayList<>();
                stat.put(word, loc);
            }
            loc.add(++wordCount);
        }
        TreeMap<Integer, String> words = new TreeMap<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : stat.entrySet()) {
            for (Integer pos : entry.getValue()) {
                words.put(pos, entry.getKey());
            }
        }
        //Test the correctness
        System.out.println(origWords);
        System.out.println(words.values());
    }

}
