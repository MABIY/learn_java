package enumerated;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify control/VowelsAndConsonants.java so that
 * it uses three enum types: VOWSEL,SOMETIMES_A_VOWEL,
 * and CONSONANT. The enum constructor should take
 * the various letters that describe that particular
 * category. Hint: Use varargs, and remember that
 * varargs automatically creates an array for your
 */
enum CharacterCategory{
    VOWEL('a','e','i','o','u'){
        @Override
        public String toString() {
            return "vowel";
        }
    },
    SOMETIMES_A_VOWEL('y','w'){
        @Override
        public String toString() {
            return "sometimes a vowel";
        }
    },
    CONSONANT {
        @Override
        public String toString() {
            return "consonant";
        }
    },;
    private HashSet<Character> chars = new HashSet<>();

    CharacterCategory(Character... chars) {
        if (chars != null) {
            this.chars.addAll(Arrays.asList(chars));
        }
    }

    public static CharacterCategory getCategory(Character c) {
        if (VOWEL.chars.contains(c)) {
            return VOWEL;
        }
        if (SOMETIMES_A_VOWEL.chars.contains(c)) {
            return SOMETIMES_A_VOWEL;
        }
        return CONSONANT;

    }
}
public class E05_VowelsAndConsonants2 {
    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            print((char) c + ", " + c + ": ");
            print(
                    CharacterCategory.getCategory((char)c).toString()
            );
        }
    }
}
