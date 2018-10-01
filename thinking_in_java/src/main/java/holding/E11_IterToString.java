package holding;

import java.util.*;

public class E11_IterToString {
    public static void printToStrings(Iterator<?> it) {
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public static void main(String[] args) {
        List<Collection<String>> ca = Arrays.asList(
                new ArrayList<>(),
                new LinkedList<>(),
                new HashSet<>(),
                new TreeSet<>()
        );
        for (Collection<String> c : ca) {
            E04_MovieNameGenerator.fill(c);
        }
        for (Collection<String> c : ca) {
            printToStrings(c.iterator());
        }
    }
}
