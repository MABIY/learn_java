package containers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 * Create a container that encapsulates an array of
 * String, and that only allows adding Strings and
 * getting Strings. and getting Strings, so that  there
 * are no casting issuses during use. if the internal array
 * isn't big enough for the next add, your container should
 * automatically resize it. In main(), compare the
 * preformance of your container with an ArrayList<String>.
 **/
class StringContainer{
    private String[] array;
    private int index;
    private static final int INCR = 255;

    public StringContainer() {
        array = new String[10];
    }

    public StringContainer(int sz) {
        array = new String[sz];
    }

    public void add(String s) {
        if (index >= array.length) {
            String[] tmp = new String[array.length + INCR];
            for (int i = 0; i < array.length; i++) {
                tmp[i] = array[i];
            }
            index = array.length;
            array = tmp;
        }
        array[index++] = s;
    }

    public String get(int i) {
        return array[i];
    }

    public int size() {
        return index;
    }
}
public class E31_StringContainer {
    static final int LOOPS = 10000;
    static List<Test<List<String>>> alTests = new ArrayList<>();
    static List<Test<StringContainer>> scTests = new ArrayList<>();
    static {
        alTests.add(new Test<List<String>>("addget") {
            @Override
            int test(List<String> list, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    list.add(Integer.toString(i));
                    list.get(i);
                }
                return LOOPS;
            }
        });
        scTests.add(new Test<StringContainer>("addget") {
            @Override
            int test(StringContainer sc, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    sc.add(Integer.toString(i));
                    sc.get(i);
                }
                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        // Parameters are also hard-coded inside tests:
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<String>(LOOPS), alTests);
        Tester.run(new StringContainer(LOOPS),scTests);
    }
}
