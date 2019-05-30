package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author lh
 * Add a second parameterized exception to the
 * Processor class and demonstrate the exceptions
 * can vary independently
 **/
interface Processor36<T,E extends Exception,F extends Exception>{
    void process(List<T> resultCollector) throws E ,F;
}

class ProcessRunner36<T ,E extends Exception,F extends Exception> extends ArrayList<Processor36<T,E,F>> {
    List<T> processAll() throws E ,F {
        List<T> resultCollector = new ArrayList<>();
        for (Processor36<T, E, F> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1_1 extends Exception{}
class Failure1_2 extends Exception{}
class Processor361 implements Processor36<String,Failure1_1,Failure1_2>{
    static Random rnd = new Random(47);
    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws Failure1_1,Failure1_2 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0) {
            if (rnd.nextBoolean()) {
                throw new Failure1_1();
            }
            throw new Failure1_2();
        }
    }
}

class Failure2_1 extends Exception{}
class Failure2_2 extends Exception{}

class Processor362 implements Processor36<Integer, Failure2_1, Failure2_2> {
    static Random rnd = new Random(47);
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws Failure2_1, Failure2_2 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }

        if (count < 0) {
            if (rnd.nextBoolean()) {
                throw new Failure2_1();
            }
            throw new Failure2_2();
        }
    }
}
public class E36_GenericExceptions {
    public static void main(String[] args) {
        ProcessRunner36<String, Failure1_1, Failure1_2> runner = new ProcessRunner36<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor361());
        }
        try {
            System.out.println(runner.processAll());
        } catch (Failure1_2 | Failure1_1 e) {
            System.out.println(e);
        }
        ProcessRunner36<Integer, Failure2_1, Failure2_2> runner2 = new ProcessRunner36<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor362());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2_1 | Failure2_2 e) {
            System.out.println(e);
        }
    }
}
