package concurrency;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * @authjr lh
 * Modify ToastOMatic.java to create peanut butter nad jelly
 * on toast sandwiches using two separate assembly lines
 * (one for peanut butter, the second for jelly, hten
 * merging the two lines).
 */
class Toast29{
    public enum Status{
        DRY,
        BUTTERED,
        JAMMED,
        READY{
            @Override
            public String toString() {
                return BUTTERED.toString() + "& " + JAMMED.toString();
            }
        }
    }

    private  Status status = Status.DRY;

    private final int id;

    public Toast29(int id) {
        this.id = id;
    }

    public void butter() {
        status = (status == Status.DRY) ? Status.BUTTERED : Status.READY;
    }

    public void jam() {
        status = (status == Status.DRY) ? Status.JAMMED : Status.READY;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue29 extends LinkedBlockingQueue<Toast29>{
}

class Toaster29 implements Runnable {
    private ToastQueue29 toastQuue;
    private int count;
    private Random rand = new Random(47);

    public Toaster29(ToastQueue29 toastQuue) {
        this.toastQuue = toastQuue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast29 t = new Toast29(count++);
                print(t);
                // Insert into queue
                toastQuue.put(t);
            }
        } catch (InterruptedException e) {
            print("Toaster interrupted");
        }
        print("Toaster off");
    }
}

// Apply butter to toast
class Butterer29 implements Runnable {
    private ToastQueue29 inQueue, butteredQueue;

    public Butterer29(ToastQueue29 inQueue, ToastQueue29 butteredQueue) {
        this.inQueue = inQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast29 t = inQueue.take();
                t.butter();
                print(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            print("Butterer interrupted");
        }
        print("butterer off");
    }
}

// Apply jam to toast
class Jammer29 implements Runnable {
    private ToastQueue29 inQueue, jammedQueue;

    public Jammer29(ToastQueue29 inQueue, ToastQueue29 jammedQueue) {
        this.inQueue = inQueue;
        this.jammedQueue = jammedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast29 t = inQueue.take();
                t.jam();
                print(t);
                jammedQueue.put(t);
            }
        } catch (InterruptedException e) {
            print("Jammer interrupted");
        }
        print("Jammer off");
    }
}

// Consume the toast:
class Eater29 implements Runnable {
    private ToastQueue29 finishedQueue;

    public Eater29(ToastQueue29 finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast29 t = finishedQueue.take();
                // Verify that all pieces are ready of consumption
                System.out.println(Thread.currentThread() + " input:" + t);
                if (t.getStatus() != Toast29.Status.READY) {
                    print(Thread.currentThread() + " >>>> Error: " + t);
                    System.exit(1);
                } else {
                    print("Chomp! " + t);
                }
            }
        } catch (InterruptedException e) {
            print("Eater interrupted");
        }
        print("Eater off");
    }
}

// Outputs alternate inputs on alternate channels:
class Alternator implements Runnable {
    private ToastQueue29 inQueue,out1Queue, out2Queue;
    private boolean outTo2; //control alternation

    public Alternator(ToastQueue29 inQueue, ToastQueue29 out1Queue, ToastQueue29 out2Queue) {
        this.inQueue = inQueue;
        this.out1Queue = out1Queue;
        this.out2Queue = out2Queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast29 t = inQueue.take();
                if (!outTo2) {
                    out1Queue.put(t);
                } else {
                    out2Queue.put(t);
                }
                outTo2 = !outTo2; // change state for next time
            }
        } catch (InterruptedException e) {
            print("Alternator interrupted");
        }
        print("Alternator off");
    }
}

// Accepts toasts on either channel, and relays them on to
// a "single" successor
class Merger implements Runnable {
    private ToastQueue29 in1Queue, in2Queue,toBeButteredQueue,
    toBeJammedQueue, finishedQueue;

    public Merger(ToastQueue29 in1Queue, ToastQueue29 in2Queue, ToastQueue29 toBeButteredQueue, ToastQueue29 toBeJammedQueue, ToastQueue29 finishedQueue) {
        this.in1Queue = in1Queue;
        this.in2Queue = in2Queue;
        this.toBeButteredQueue = toBeButteredQueue;
        this.toBeJammedQueue = toBeJammedQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast29 t = null;
                while (t == null) {
                    t = in1Queue.poll(50, TimeUnit.MILLISECONDS);
                    if (t != null) {
                        break;
                    }
                    t = in2Queue.poll(50, TimeUnit.MILLISECONDS);
                }
                // Relay toast onto proper queue
                switch (t.getStatus()) {
                    case BUTTERED:
                        toBeJammedQueue.put(t);
                        break;
                    case JAMMED:
                        toBeButteredQueue.put(t);
                        break;
                    default:
                        finishedQueue.put(t);
                }
            }
        } catch (InterruptedException e) {
            print("Merger interrupted");
        }
        print("Mergrer off");
    }
}
public class E29_ToastOMatic2 {
    public static void main(String[] args) {
        ToastQueue29 dryQueue = new ToastQueue29(),
                butteredQueue = new ToastQueue29(),
                toBeButteredQueue = new ToastQueue29(),
                jammedQueue = new ToastQueue29(),
                toBeJammedQueue = new ToastQueue29(),
                finishedQueue = new ToastQueue29();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster29(dryQueue));
        exec.execute(new Alternator(dryQueue, toBeButteredQueue, toBeButteredQueue));
        exec.execute(new Jammer29(toBeButteredQueue, butteredQueue));
        exec.execute(new Jammer29(toBeJammedQueue, jammedQueue));
        exec.execute(new Merger(butteredQueue, jammedQueue, toBeButteredQueue, toBeJammedQueue, finishedQueue));
        exec.execute(new Eater29(finishedQueue));

    }
}
