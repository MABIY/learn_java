package containers;

import containers.Test;
import containers.TestParam;
import containers.Tester;
import net.lh.util.CountingGenerator;
import net.lh.util.Generator;

import java.util.*;

/**
 * @author lh
 * {Args: 1000 500} Medium to keep build testing reasonable
 * Modify SetPerformance.java so that the Sets hold String
 * objects instead of Integers. Use a Generator from the
 * Arrays chapter to create test values
 **/
public class E34_StringSetPerformance {
    static List<Test<Set<String>>> tests = new ArrayList<>();
    static {
        tests.add(new Test<Set<String>>("add") {
            @Override
            int test(Set<String> set, TestParam tp) {
                Generator<String> gen;
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    // Always starts the sequence from the beginning.
                    gen = new CountingGenerator.String();
                    for (int j = 0; j < size; j++) {
                        set.add(gen.next());
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            @Override
            int test(Set<String> set, TestParam tp) {
                Generator<String> gen = new CountingGenerator.String(5);
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < span; i++) {
                    set.contains(gen.next());
                }
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            @Override
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<>(),tests);
        Tester.run(new HashSet<>(),tests);
        Tester.run(new LinkedHashSet<>(),tests);
    }
}
