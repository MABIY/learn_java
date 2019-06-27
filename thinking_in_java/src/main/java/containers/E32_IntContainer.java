package containers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 * Repeat teh previous exercise for a container of
 * int, and compare the performance to an
 * ArrayList<Integer>. In your performance comparsion.
 * include the process of incrementing each object
 * int the container.
 **/
class IntContainer{
    private int[] array;
    private int index;
    private static final int INCR = 255;

    public IntContainer() {
        array = new int[10];
    }

    public IntContainer(int sz) {
        array = new int[sz];
    }

    public void add(int i) {
        if (index >= array.length) {
            int[] tmp = new int[array.length + INCR];
            for (int j = 0; j < array.length; j++) {
                tmp[i] = array[j];
            }
            index = array.length;
            array = tmp;
        }
        array[index++] = i;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int val) {
        array[i] = val;
    }
    public int size() {
        return index;
    }
}
public class E32_IntContainer {
    static final int LOOPS = 10000;
    static List<Test<List<Integer>>> alTests = new ArrayList<>();
    static List<Test<IntContainer>> icTests = new ArrayList<>();
    static {
        alTests.add(new Test<List<Integer>>("addget") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    list.add(i);
                    list.set(i, list.get(i) + 1);
                }
                return LOOPS;
            }
        });
        icTests.add(new Test<IntContainer>("addget") {
            @Override
            int test(IntContainer ic, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    ic.add(i);
                    ic.set(i, ic.get(i) + 1);
                }
                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        // Parameters are also hard-coded inside tests
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<>(LOOPS),alTests);
        Tester.run(new IntContainer(LOOPS),icTests);
    }
}
