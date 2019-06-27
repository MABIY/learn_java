package containers;

import containers.Test;
import containers.TestParam;
import containers.Tester;
import net.lh.util.CollectionData;
import net.lh.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lh
 * Compare the performance of Collection.sort()
 * between an ArrayList and a linkedList.
 **/
public class E30_SortPerformance {
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static {
        tests.add(new Test<List<Integer>>("sort") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                for (int i = 0; i < tp.loops; i++) {
                    list.clear();
                    list.addAll(CollectionData.list(
                            new RandomGenerator.Integer(), tp.size
                    ));
                    Collections.sort(list);

                }
                return tp.loops;
            }
        });
    }

    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        // Fill to the appropriate size before each test:
        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(CollectionData.list(
                    new RandomGenerator.Integer(), size
            ));
            return container;
        }

        // Convenience methods:
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }

        public static void main(String[] args) {
            if (args.length > 0) {
                Tester.defaultParams = TestParam.array(args);
            }
            ListTester.run(new ArrayList<Integer>(), tests);
            ListTester.run(new LinkedList<>(), tests);

        }
    }
}
