package holding;

import net.mindview.util.TextFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static net.mindview.util.Print.print;

public class E16_Vowels {
    public static final Set<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I')
    );

    public static void main(String[] args) {
        HashSet<String> processedWords = new HashSet<>();
        int fileVowels = 0;
        int wordVowels;
        for (String word : new TextFile("/data/project/learn_java/thinking_in_java/src/main/java/holding/SetOperations.java",
                "\\W+")) {
            wordVowels = 0;
            for (char letter : word.toCharArray()) {
                if (vowels.contains(letter)) {
                    wordVowels++;
                }
            }

            if (!processedWords.contains(word)) {
                processedWords.add(word);
                print(word + " has " + wordVowels + " vowel(s)");
            }
            fileVowels += wordVowels;
        }
        print("Total number of vowels in file: " + fileVowels);
    }
}
