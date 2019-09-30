package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Add a BusBoy class to Restaurant.jva . After the meal is
 * delivered, the WaitPerson should notify the BusBoy to
 * clean up
 */
class WaitPerson2 implements Runnable {
    boolean notified;
    private Restaurant2 restaurant2;

    public WaitPerson2(Restaurant2 restaurant2) {
        this.restaurant2 = restaurant2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant2.meal == null) {
                        wait();// ... for hte chef to produce a meal
                    }
                }
                print("Waitperson got " + restaurant2.meal);
                synchronized (restaurant2.buyBoy) {
                    restaurant2.buyBoy.notified = true;
                    restaurant2.buyBoy.meal = restaurant2.meal;
                    restaurant2.buyBoy.notifyAll(); //Clean up
                }
                synchronized (restaurant2.chef2) {
                    restaurant2.meal = null;
                    restaurant2.chef2.notifyAll(); //Ready for  another
                }
                synchronized (this) {
                    if (!notified) {
                        wait();// ... for the bus boy to clean up
                    }
                    notified = false;
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class BuyBoy implements Runnable {
    boolean notified;
    volatile Meal meal;
    private Restaurant2 restaurant2;

    public BuyBoy(Restaurant2 restaurant2) {
        this.restaurant2 = restaurant2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while(!notified) {
                        wait(); // .. for meal delivery
                    }
                    notified = false;
                }
                print("Busboy cleaned up " + meal);
                synchronized (restaurant2.waitPerson2) {
                    restaurant2.waitPerson2.notified = true;
                    restaurant2.waitPerson2.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            print("BusBoy interrupted");
        }
    }
}

class Chef2 implements Runnable {
    private Restaurant2 restaurant2;
    private int count = 0;

    public Chef2(Restaurant2 restaurant2) {
        this.restaurant2 = restaurant2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant2.meal != null) {
                        wait();// ... for the emal to be taken
                    }
                }
                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant2.exes.shutdownNow();
                }
                print("Order up!");
                synchronized (restaurant2.waitPerson2) {
                    restaurant2.meal = new Meal(count);
                    restaurant2.waitPerson2.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}

class Restaurant2 {
    Meal meal;
    ExecutorService exes = Executors.newCachedThreadPool();
    WaitPerson2 waitPerson2 = new WaitPerson2(this);
    BuyBoy buyBoy = new BuyBoy(this);
    Chef2 chef2 = new Chef2(this);

    public Restaurant2() {
        exes.execute(chef2);
        exes.execute(waitPerson2);
        exes.execute(buyBoy);
    }
}

public class E26_Restaurant2 {
    public static void main(String[] args) {
        new Restaurant2();
    }
}
