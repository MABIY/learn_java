package concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify Restaurant.java to use explicit Lock and Conditionj objects
 */
class WaitPerson3 implements Runnable {
    private Restaurant3 restaurant3;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public WaitPerson3(Restaurant3 restaurant3) {
        this.restaurant3 = restaurant3;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant3.meal == null) {
                        condition.await();
                    }

                } finally {
                    lock.unlock();
                }
                print("Waitperson got " + restaurant3.meal);
                restaurant3.chef.lock.lock();
                try {
                    restaurant3.meal = null;
                    restaurant3.chef.condition.signalAll();
                }finally {
                    restaurant3.chef.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrrupted");
        }
    }
}

class Chef3 implements Runnable {
    private Restaurant3 restaurant3;
    private int count;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public Chef3(Restaurant3 restaurant3) {
        this.restaurant3 = restaurant3;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant3.meal != null) {
                        condition.await();
                    }
                }finally {
                    lock.unlock();
                }
                if (++count == 10) {
                    print("Out of food ,closing");
                    restaurant3.exec.shutdownNow();
                }
                print("Order up! ");
                restaurant3.waitPerson3.lock.lock();
                try {
                    restaurant3.meal = new Meal(count);
                    restaurant3.waitPerson3.condition.signalAll();
                }finally {
                    restaurant3.waitPerson3.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}
class Restaurant3{
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson3 waitPerson3 = new WaitPerson3(this);
    Chef3 chef = new Chef3(this);

    public Restaurant3() {
        exec.execute(chef);
        exec.execute(waitPerson3);
    }
}
public class E27_Restaurant3 {
    public static void main(String[] args) {
        new Restaurant3();
    }
}
