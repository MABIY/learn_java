package holding;

import net.mindview.util.TextFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Create a Set of the vowels. Working from
 * UniqueWords.java, count and display the number of
 * vowels in each input word, and also display the
 * total number of  vowels in the input file.
 **/
public class E16_Vowels {
    private final static Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I'
    ));

    public static void main(String[] args) {
        HashSet<String> processedWords = new HashSet<>();
        int fileVowels = 0;
        int wordVowels;
        for (String word : new TextFile("thinking_in_java/src/main/java/holding/E16_Vowels.java", "\\W+")) {
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
