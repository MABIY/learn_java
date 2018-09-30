package holding;

import net.mindview.util.Generator;

import java.util.*;

import static net.mindview.util.Print.print;

class MovieNameGenerator implements Generator<String> {
    String[] characters = {
            "Grumpy", "Happy", "Sleepy", "Dopey", "Doc", "Sneezy",
            "Bashful", "Snow White", "Witch Queen", "Prince"
    };
    int next;

    @Override
    public String next() {
        String r = characters[next];
        next = (next + 1) % characters.length;
        return r;
    }
}
public class E04_MovieNameGenerator {
    private static final MovieNameGenerator mng = new MovieNameGenerator();

    static String[] fill(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = mng.next();
        }
        return array;
    }

    static Collection<String> fill(Collection<String> collection) {
        for (int i = 0; i < 5; i++) {
            collection.add(mng.next());
        }
        return collection;
    }

    public static void main(String[] args) {
        print(Arrays.toString(fill(new String[5])));
        print(fill(new ArrayList<>()));
        print(fill(new LinkedHashSet<>()));
        print(fill(new HashSet<>()));
        print(fill(new LinkedHashSet<>()));
        print(fill(new TreeSet<>()));
    }

}
