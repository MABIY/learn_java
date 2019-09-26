package concurrency;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lh
 * {Args: 100}
 * **************** Exercise 14 ************************
 * Demonstrate that java.util.Timer scales to large numbers
 * by creating a program that generates many Timer objects
 * that perform some simple task when the timeout completes
 * ****************************************
 */
public class E14_ManyTimers {
    public static void main(String[] args) {
        args = new String[]{"100"};
        if (args.length < 1) {
            System.out.println(
                    "Usage: java E14_ManyTimers <num of tiemrs>"
            );
        }
        int numOfTimers = Integer.parseInt(args[0]);
        for (int i = 0; i < numOfTimers; i++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis());

                }
            },numOfTimers -i);
        }
    }
}
