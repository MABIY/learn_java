package typeinfo.pets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Add a char filed to CountedString that is also
 * initialized in the constructor, and modify the
 * hashCode() and equals() methods to include
 * the vlaue of this char.
 **/

class CountedString2 {
    private static List<String> created = new ArrayList<>();
    private String s;
    private char c;
    private int id;

    public CountedString2(String s, char c) {
        this.s = s;
        this.c = c;
        created.add(s);
        // id is the total number of instances
        // of this string in use by CountedString2:
        for (String s1 : created) {
            if (s1.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " char: " + c + " hashCode(): " + hashCode();
    }

    @Override
    public int hashCode() {
        // The very simple approach
        // return s.hashCode() * id
        // Using Joshua Bloch's recipe
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        result = 37 * result + c;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString2 &&
                s.equals(((CountedString2) obj).s) &&
                id == ((CountedString2) obj).id &&
                c == ((CountedString2) obj).c;
    }
}

public class E26_CountedString2 {
    public static void main(String[] args) {
        Map<CountedString2, Integer> map = new HashMap<>();
        CountedString2[] cs = new CountedString2[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString2("hi", 'c');
            map.put(cs[i], i); // Autobox int -> Integer
        }
        print(map);
        for (CountedString2 cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
}
