package holding;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(
                new TextFile("/data/project/learn_java/thinking_in_java/src/main/java/holding/SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}
