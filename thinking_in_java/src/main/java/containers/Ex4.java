package containers;

import net.mindview.util.TextFile;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Create a Collection initializer that opens a file and breaks
 * it into words using TexFile, and then uses the words as the
 * source of data for hte resulitng colelction. Demonstrate that
 * it works
 **/
public class Ex4 {
    static Collection<String> CollectFromText(String fileName) {
        String[] sa = TextFile.read(fileName).split(" ");
        return Arrays.asList(sa);
    }

    static Collection<String> CollectFromText2(String fileName) {
        String[] sa = TextFile.read(fileName).split(" ");
        return new TreeSet<>(new TextFile(fileName, "\\W+"));
    }

    public static void main(String[] args) {
        print(CollectFromText("thinking_in_java/src/main/java/containers/Ex4.java"));
        print(CollectFromText2("thinking_in_java/src/main/java/containers/Ex4.java"));
    }
}
