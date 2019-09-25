package concurrency;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Understanding join()
 */
class Sleeper extends Thread{
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            print(getName() + " was interrupted. " +
                    "isInterrupted(): " + isInterrupted());
            return;
        }
        print(getName() + " has awakened");
    }
}
class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            print("Interrupted");
        }
        print(getName() + " join completed");
    }
}
public class Joining {
    public static void main(String[] args) {
        Sleeper sleepey = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleepey),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}
