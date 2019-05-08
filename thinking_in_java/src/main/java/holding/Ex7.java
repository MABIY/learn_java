package holding;

import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Create a class, then make an initialized array of objects of your class
 * Fill a List from your array. Create a subset of yoour list of using
 * sublist(), then remove this subset from your List.
 **/
class Tester{
    public static int counter = 0;
    private int id = counter++;

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
public class Ex7 {
    public static void main(String[] args) {
        Tester[] t = new Tester[10];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Tester();
        }
        List<Tester> lt = new ArrayList<>();
        for (Tester x : t) {
            lt.add(x);
        }
        print("list of Tester: " + lt);
        List<Tester> sub = lt.subList(2, 6);
        print("subList: " + sub);
        // Produces run time ConcurrentModificationException:
        // lt.removeAll(sub);
        // so , first make copy, remove sub, re-assign it:
        List<Tester> copy = new ArrayList<>(lt);
        copy.removeAll(sub);
        print("copy: " + copy);
        lt = copy;
        print("list of Tester: " + lt);
    }
}
