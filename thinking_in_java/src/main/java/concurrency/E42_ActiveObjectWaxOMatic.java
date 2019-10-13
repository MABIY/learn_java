package concurrency;

import java.util.concurrent.*;

import static net.lh.util.Print.print;
import static net.lh.util.Print.printnb;

/**
 * @author lh
 * Modify WaxOMatic.java sot that it implements active objects.
 **/

class ActiveCar{
    private ExecutorService ex = Executors.newSingleThreadExecutor();
    private enum Action {
        WAX,BUFF
    }

    private Action lastAction = Action.BUFF;

    private boolean waxOn;

    public void wax(){
        try {
            ex.execute(waxingTask);
        } catch (RejectedExecutionException e) {
        }
    }

    public void buff() {
        try {
            ex.execute(buffingTask);
        } catch (RejectedExecutionException e) {
        }
    }

    public void shutdown() {
        ex.shutdown();
    }

    private static void pause(int sleep_time) {
        try {
            TimeUnit.MILLISECONDS.sleep(sleep_time);
        } catch (InterruptedException e) {
            print("sleep() interupted");
        }
    }

    private class WaxingTask implements Runnable {
        @Override
        public void run() {
            if (lastAction != Action.WAX) {
                printnb("Wax on!");
                pause(200);
                waxOn = true;
                lastAction = Action.WAX; } } }

    private final WaxingTask waxingTask = new WaxingTask();

    private class BuffingTask implements Runnable {
        @Override
        public void run() {
            if (lastAction != Action.BUFF) {
                printnb("Wax Off!");
                pause(200);
                waxOn = false;
                lastAction = Action.BUFF;
            }
        }
    }

    private final BuffingTask buffingTask = new BuffingTask();
}

class WaxCar implements Runnable {
    private final ActiveCar car;

    public WaxCar(ActiveCar car) {
        this.car = car;
    }

    @Override
    public void run() {
        car.wax();
    }
}

class BufferCar implements Runnable {
    private final ActiveCar car;

    public BufferCar(ActiveCar car) {
        this.car = car;
    }

    @Override
    public void run() {
        car.buff();
    }
}
public class E42_ActiveObjectWaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        ActiveCar car = new ActiveCar();
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
        exec.scheduleAtFixedRate(new BufferCar(car), 0, 200, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(new WaxCar(car), 0, 200, TimeUnit.MILLISECONDS);
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow();
        car.shutdown();
    }
}
