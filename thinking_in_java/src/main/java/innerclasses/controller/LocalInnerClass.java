package innerclasses.controller;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Holds a sequence Objects
 **/
interface Counter{
    int next();
}
public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        // A local inner class:
        class LocalCounter implements Counter{
            public LocalCounter() {
                // Local inner class can have a constructor
                print("LocalCounter()");
            }

            @Override
            public int next() {
                print(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }

    //The same thing with an anonymous inner class:
    Counter getCounter2(final String name) {
        return new Counter() {
            // Anonymous inner class cannot have a named
            // constructor. only an instance initializer:
            {
                print("Counter()");
            }

            @Override
            public int next() {
                print(name); // Access local final
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner");
        for (int i = 0; i < 5; i++) {
            print(c1.next());
        }
        for (int i = 0; i < 5; i++) {
            print(c2.next());
        }

    }
}
