package holding;

import net.mindview.util.TextFile;

import java.util.*;

class WordCounter {
    public static final Comparator<WordCounter> CASE_INSENSITIVE_ORDER =
            new Comparator<WordCounter>() {
                @Override
                public int compare(WordCounter o1, WordCounter o2) {
                    return o1.word.compareToIgnoreCase(o2.word);
                }
            };
    private final String word;
    private int frequency;

    public WordCounter(String word) {
        this.word = word;
        frequency = 1;
    }

    void incFrequency() {
        ++frequency;
    }

    String getWord() {
        return word;
    }
    int getFrequency() {
        return frequency;
    }

    public boolean equals(Object o) {
        return o instanceof WordCounter &&
                word.equals(((WordCounter) o).word);
    }

    public int hashCode() {
        return word.hashCode();
    }
}
public class E22_WordsInfo2 {
    static void updateSta(Iterator<WordCounter> it, WordCounter wc) {
        while (it.hasNext()) {
            WordCounter currentWC = it.next();
            if (currentWC.equals(wc)) {
                currentWC.incFrequency();
            }
        }
    }

    public static void main(String[] args) {
        Set<WordCounter> stat = new HashSet<>();
        for (String word : new TextFile("/data/project/learn_java/thinking_in_java/src/main/java/holding/E22_WordsInfo2.java", "\\W+")) {
            WordCounter wc = new WordCounter(word);
            if (stat.contains(wc)) {
                updateSta(stat.iterator(), wc);
            } else {
                stat.add(wc);
            }
        }
        List<WordCounter> l = new ArrayList<>(stat);
        Collections.sort(l, WordCounter.CASE_INSENSITIVE_ORDER);
        for (WordCounter wc : l) {
            System.out.println(wc.getWord()+ " => "+ wc.getFrequency());
        }
    }
}
