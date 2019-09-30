package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * In the chef class in Restaurant.java. return from run()
 * after calling shutdownNow() adn observe the difference
 * in behavior
 */

class Meal25 {
    private final int orderNum;

    public Meal25(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson25 implements Runnable {
    private Restaurant25 restaurant;

    public WaitPerson25(Restaurant25 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait(); //... for the cheft to produce a meal
                    }
                }
                print("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); //Ready for another
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class Chef25 implements Runnable {
    private Restaurant25 restaurant;
    private int count = 0;

    public Chef25(Restaurant25 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait(); // ... for the meal to be taken
                    }
                }
                if (++count == 10) {
                    print("OUt of food, closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                print("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}

class Restaurant25 {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson25 waitPerson = new WaitPerson25(this);
    Chef25 chef = new Chef25(this);

    public Restaurant25() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant25();
    }
}

