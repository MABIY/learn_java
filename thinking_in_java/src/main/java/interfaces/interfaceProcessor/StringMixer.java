package interfaces.interfaceProcessor;

/**
 * @author lh
 * Create a class with a method that take a String argument and produces a result
 * that swaps each pair of characters in argument.Adapt the class so that it
 * works with interfaceprocessor.Apply.process().
 **/
public class StringMixer {
    static String process(String s) {
        char[] ca = new char[s.length()];
        if (s.length() % 2 == 0) {
            for (int i = 0; i < s.length(); i += 2) {
                ca[i] = s.charAt(i + 1);
                ca[i + 1] = s.charAt(i);
            }
            return new String(ca);
        } else {
            for (int i = 0; i < s.length() - 1; i +=2) {
                ca[i] = s.charAt(i + 1);
                ca[i + 1] = s.charAt(i);
            }
            ca[s.length() - 1] = s.charAt(s.length() - 1);
            return new String(ca);
        }
    }
}
