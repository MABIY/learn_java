package concurrency;

import com.sun.javafx.logging.JFRInputEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * A complex example of tasks working together.
 */

class Car {
    private final int id;
    private boolean engine = false,
            driveTrain = false,
            wheels = false;

    // Empty Car object:
    public Car() {
        id = -1;
    }

    public Car(int id) {
        this.id = id;
    }

    public synchronized int getId() {
        return id;
    }
    public synchronized void addEngine() {
        engine = true;
    }
    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    public synchronized String toString() {
        return "Car " + id + " [" + " engine: " + engine
                + " driveTrain: " + driveTrain
                + " wheels: " + wheels + " ]";
    }
}

class CarQueue extends LinkedBlockingQueue<Car>{}

class ChassisBuilder implements Runnable {
    private CarQueue carQueue;
    private int counter = 0;

    public ChassisBuilder(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                // Make chassis:
                Car c = new Car(counter++);
                print("ChassisBuilder created " + c);
                // Insert into queue
                carQueue.put(c);
            }
        } catch (InterruptedException e) {
            print("Interrupted: ChassisBuilder");
        }
        print("ChassisBuilder off");
    }
}

class Assembler implements Runnable {
    private CarQueue chassisQueue, finishingQueue;
    private  Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    public Assembler(CarQueue chassisQueue, CarQueue finishingQueue, RobotPool robotPool) {
        this.chassisQueue = chassisQueue;
        this.finishingQueue = finishingQueue;
        this.robotPool = robotPool;
    }

    public Car car() {
        return car;
    }


    public CyclicBarrier barrier() {
        return barrier;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until chassis is available:
                car = chassisQueue.take();
                // Hire robots to perform work:
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await(); // Until the robots finish
                // Put car into finishingQueue for further work
                finishingQueue.put(car);
            }
        } catch (InterruptedException e) {
            print("Exiting Assembler vvia interrupt");
        } catch (BrokenBarrierException e) {
            // This one we want to know about
            throw new RuntimeException(e);
        }
        print("Assembler off");
    }
}

class Reporter implements Runnable {
    private CarQueue carQueue;

    public Reporter(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                print(carQueue.take());
            }
        } catch (InterruptedException e) {
            print("Exiting Reporter via interupt");
        }
        print("Reporter off");
    }
}

abstract class Robot implements Runnable {
    private RobotPool pool;

    public Robot(RobotPool pool) {
        this.pool = pool;
    }

    protected  Assembler assembler;

    public Robot assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    private boolean engage = false;

    public synchronized void engage() {
        engage = true;
        notifyAll();
    }

    // The part of run() that's different for each robot:
    abstract protected void performService();

    @Override
    public void run() {
        try {
            powerDown(); //Wait until needed
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await();// Synchronize
                // We're done with that job...
                powerDown();
            }
        } catch (InterruptedException e) {
            print("Exiting " + this + " vai interrupt");
        } catch (BrokenBarrierException e) {
            // This is one we want to know about
            throw new RuntimeException(e);
        }
        print(this + " off");
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null; // Disconnect from the Assembler
        // Put ourselves back in the available pool:
        pool.release(this);
        while (engage == false) { // Power Down
            wait();
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "pool=" + pool +
                ", assembler=" + assembler +
                ", engage=" + engage +
                '}';
    }
}
class EngineRobot extends Robot{
    public EngineRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing engine");
        assembler.car().addEngine();
    }
}
class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing DeriveTrain");
        assembler.car().addDriveTrain();
    }
}

class WheelRobot extends Robot {
    public WheelRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing Wheels");
        assembler.car().addWheels();
    }
}

class RobotPool{
    // Quietly prevents identical entries:
    private Set<Robot> pool = new HashSet<>();

    public synchronized void add(Robot r) {
        pool.add(r);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException {
        for (Robot r : pool) {
            if (r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssembler(d);
                r.engage(); // Power it up to do the task
                return;
            }
        }
        wait();
        hire(robotType, d); // Try again, recursively
    }

    public synchronized void release(Robot r) {
        add(r);
    }
}
public class CarBuilder {
    public static void main(String[] args) throws InterruptedException {
        CarQueue chassisQueue = new CarQueue(),
                finishingQueue = new CarQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();
        exec.execute(new EngineRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));
        exec.execute(new Assembler(chassisQueue, finishingQueue, robotPool));
        exec.execute(new Reporter(finishingQueue));
        // Start everything running by producing chassis:
        exec.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();

    }
}