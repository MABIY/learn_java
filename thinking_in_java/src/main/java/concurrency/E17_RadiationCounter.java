package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Create a radiation counter that can have any number of remote sensors
 */
class Sensor implements Runnable {
    private static Random rand = new Random(47);
    private static Count count = new Count();
    private static List<Sensor> sensors = new ArrayList<>();
    private static volatile boolean canceled = false;
    private final int id;
    private int number;

    public Sensor(int id) {
        this.id = id;
        sensors.add(this);
    }

    public static void cancel() {
        canceled = true;
    }

    public static int sumSensors() {
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.getValue();
        }
        return sum;
    }

    public static int getTotalCount() {
        return count.value();
    }

    @Override
    public void run() {
        while (!canceled) {
            // Simulate a random occurence of an ionizing event
            if (rand.nextInt(5) == 0) {
                synchronized (this) {
                    ++number;
                }
                count.increment();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                print("sleep interrupted");
            }
        }
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }
}

public class E17_RadiationCounter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Sensor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Sensor.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            print("Some tasks were not terminated!");
        }
        print("Total: " + Sensor.getTotalCount());
        print("Sum of Sensors: " + Sensor.sumSensors());
    }
}
