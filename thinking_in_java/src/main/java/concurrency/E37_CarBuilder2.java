package concurrency;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author lh
 * **************************************************
 * Modify CarBuilder.java to add another stage to the
 * carbuilding process, which adds the exhaust systemr,
 * body, and fenders, as with the second state, assume these
 * processes can be performed simultaneously by robots
 * **************************************************
 */
class Car2{
    private final int id;
    private boolean engine = false,driveTrain = false,wheels = false,
    exhaustSystem =false, body =false, fender = false;

    public Car2(int id) {
        this.id = id;
    }

    public Car2() {
        id = -1;
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

    public synchronized void addExhaustSystem() {
        exhaustSystem = true;
    }

    public synchronized void addBody() {
        body = true;
    }

    public synchronized void addFender() {
        fender = true;
    }

    public synchronized String toString() {
        return "Car " + id + " [" + " engine: " + engine
                + " driveTrain: " + driveTrain
                + " wheels: " + wheels
                + " exhaust system: " + exhaustSystem
                + " body: " + body
                + " fender: " + fender + "]";
    }
}

class CarQueue2 extends LinkedBlockingQueue<Car2>{}

class ChassisBuilder2 implements Runnable {
    private CarQueue2 carQueue;
    private int counter = 0;

    public ChassisBuilder2(CarQueue2 carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                // Make chassis:
                Car2 c = new Car2(counter++);
                // INsert into queue
            }
        } catch (InterruptedException e) {
            print("Interrupted: ChassisBuilder");
        }
        print("ChassisBuilder off");
    }
}

class Assembler2 implements Runnable {
    private CarQueue2 chassisQueeu, finishingQuue;
    private Car2 car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool2 robotPool;

    public Assembler2(CarQueue2 chassisQueeu, CarQueue2 finishingQuue, RobotPool2 robotPool) {
        this.chassisQueeu = chassisQueeu;
        this.finishingQuue = finishingQuue;
        this.robotPool = robotPool;
    }

    public Car2 car() {
        return car;
    }

    public CyclicBarrier barrier() {
        return barrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blokcs until chassis is available
                car = chassisQueeu.take();
                // Hire robots to perform work (second stage)
                robotPool.hire(EngineRobot2.class, this);
                robotPool.hire(DriveTrainRobot2.class,this);
                robotPool.hire(WheelRobot2.class,this);
                barrier.await(); // Until the robots finish
                // Hire robots to perform work (third stage)
                robotPool.hire(ExhaustSystemRobot.class,this);
                robotPool.hire(BodyRobot.class,this);
                robotPool.hire(FenderRobot.class, this);
                barrier.await();
                // Put car into finishingQueue for further work
                finishingQuue.put(car);
            }
        } catch (InterruptedException e) {
            print("Exiting Assembler via interrupt");
        } catch (BrokenBarrierException e) {
            // This one we want to know about
            throw new RuntimeException(e);
        }
        print("Assembler off");
    }
}

class Reporter2 implements Runnable {
    private CarQueue2 carQueue;

    public Reporter2(CarQueue2 carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                print(carQueue.take());
            }
        } catch (InterruptedException e) {
            print("Exiting Reporter via interrupt");
        }
        print("Reporter off");
    }
}

abstract class Robot2 implements Runnable {
    private RobotPool2 pool;

    public Robot2(RobotPool2 pool) {
        this.pool = pool;
    }

    protected Assembler2 assembler;

    public Robot2 assignAssembler(Assembler2 assembler) {
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
            powerDown();//Wait until needed
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await(); // Synchronize
                // We're done with that job..
                powerDown();
            }
        } catch (InterruptedException e){
            print("Exiting " + this + " via interrupt");
        } catch (BrokenBarrierException e) {
            // This one we want to know about
            throw new RuntimeException(e);
        }
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null; // Disconnect from the Assembler
        // Put ourselves abck in the available pool:
        pool.release(this);
        while (engage == false) { // Power down
            wait();
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
class EngineRobot2 extends Robot2{

    public EngineRobot2(RobotPool2 pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing engine");
        assembler.car().addEngine();
    }
}

class DriveTrainRobot2 extends Robot2 {
    public DriveTrainRobot2(RobotPool2 pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing DriveTrain");
        assembler.car().addDriveTrain();
    }
}

class WheelRobot2 extends Robot2 {
    public WheelRobot2(RobotPool2 pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing Wheels");
        assembler.car().addWheels();
    }
}

class ExhaustSystemRobot extends Robot2{

    public ExhaustSystemRobot(RobotPool2 pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing exhausting system");
        assembler.car().addExhaustSystem();
    }
}

class BodyRobot extends Robot2 {
    public BodyRobot(RobotPool2 pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing body");
        assembler.car().addBody();
    }
}

class FenderRobot extends Robot2{
    public FenderRobot(RobotPool2 pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        print(this + " installing fendergo");
    }
}
class RobotPool2{
    // Quietly prevents identical entries:
    private Set<Robot2> pool = new HashSet<>();

    public synchronized void add(Robot2 r) {
        pool.add(r);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot2> robotType, Assembler2 d) throws InterruptedException {
        for (Robot2 r : pool) {
            if (r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssembler(d);
                r.engage(); // Power it up to do the task
                return;
            }
        }
        wait(); // None available
        hire(robotType, d); // Try again, recursively
    }

    public synchronized void release(Robot2 r) {
        add(r);
    }
}
public class E37_CarBuilder2 {
    public static void main(String[] args) throws InterruptedException {
        CarQueue2 chassisQueue = new CarQueue2(),
                finishingQueue = new CarQueue2();
        ExecutorService exec = Executors.newCachedThreadPool();
        RobotPool2 robotPool = new RobotPool2();
        exec.execute(new EngineRobot2(robotPool));
        exec.execute(new DriveTrainRobot2(robotPool));
        exec.execute(new WheelRobot2(robotPool));
        exec.execute(new ExhaustSystemRobot(robotPool));
        exec.execute(new BodyRobot(robotPool));
        exec.execute(new FenderRobot(robotPool));
        exec.execute(new Assembler2(chassisQueue, finishingQueue, robotPool));
        exec.execute(new Reporter2(finishingQueue));
        // Start everything running by producing chassic:
        exec.execute(new ChassisBuilder2(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}
