package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lh
 * {RunByHand}
 * ******************Exercise 12**********************
 * Repair AtomicityTest.java suing the synchronized
 * keyword. Can you demonstrate that it is now
 * correct?
 * ****************************************
 */
class AtomicityTest2 implements Runnable {
    private int i;

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public synchronized int getValue() {
        return i;
    }

    public synchronized void evenIncrement() {
        i++;
        i++;
    }
}
public class E12_AtomicityTest2 {
    public static void main(String[] args) {
        System.out.println("Presss Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest2 at = new AtomicityTest2();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

}
