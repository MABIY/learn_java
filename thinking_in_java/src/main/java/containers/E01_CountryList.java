package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static net.lh.util.Countries.names;
import static net.lh.util.Print.print;

/**
 * @author lh
 * Create a List (try both ArrayList and LinkedList)
 * and fill it using Countries . Sort the slist and
 * print it. then apply Collections.shuffle() to the
 * list repeatedly, printing it each time so you
 *  can see how the shuffle() method randomizes the
 *  list differently each time
 **/
public class E01_CountryList {
    private static Random rnd = new Random(47);
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(names(8));
        Collections.sort(l);
        print("sorted: " + l);
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(l, rnd);
            print("shuffled (" + i + "): " + l);
        }
    }
}
