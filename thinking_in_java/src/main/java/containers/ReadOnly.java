package containers;

import net.lh.util.Countries;

import java.util.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Using the Collections.unmodifiable methods
 **/
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(
                new ArrayList<>(data)
        );
        print(c); // Reading is OK
        // c.add("one"); //can't change OK
        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        print(lit.next());// Reading is ok
        // lit.add("one"); //Can't change it
        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        print(s); //Reading is OK
        // s.add("one"); // Can't change it

        // For a SortedSet:
        Set<String> ss = Collections.unmodifiableSortedSet(
                new TreeSet<>(data)
        );

        Map<String, String> m = Collections.unmodifiableMap(
                new HashMap<>(Countries.capitals(6))
        );
        print(m); // Reading is OK
        // m.put("Ralph", "HOwdy!");

        // For a SortedMap
        Map<String, String> sm = Collections.unmodifiableMap(
                new TreeMap<>(Countries.capitals(6))
        );
    }
}
