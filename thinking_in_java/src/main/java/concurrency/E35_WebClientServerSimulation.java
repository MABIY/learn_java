package concurrency;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author lh
 * {Args:8}
 * ****************************************
 * Modify BankTellerSimulation.java so that it represents
 * Web clients making requrest of a fixed  number of servers.
 * The goal is to determine the load that the group of
 * servers can handle
 * ****************************************
 */

class WebClient{
    private final int serviceTime;

    public WebClient(int tm) {
        this.serviceTime = tm;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}

class WebClientLine extends ArrayBlockingQueue<WebClient> {
    public WebClientLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder result = new StringBuilder();
        for (WebClient webClient : this) {
            result.append(webClient);
        }
        return result.toString();
    }
}

class WebClientGenerator implements Runnable {
    private WebClientLine clients;
    volatile int loadFactor = 1; // Start with one client/sec
    private static Random rand = new Random(47);

    public WebClientGenerator(WebClientLine cq) {
        this.clients = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                clients.put(new WebClient(rand.nextInt(100)));
                TimeUnit.MILLISECONDS.sleep(1000 / loadFactor);
            }
        } catch (InterruptedException e) {
            print("WebClientGenerator interrupted");
        }
        print("WebClientGenerator terminating");
    }
}

class Server implements Runnable {
    private static int counter;
    private final int id = counter++;
    private WebClientLine clients;

    public Server(WebClientLine cq) {
        this.clients = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                WebClient client = clients.take();
                TimeUnit.MILLISECONDS.sleep(client.getServiceTime());
            }
        } catch (InterruptedException e) {
            print(this + "interrupted");
        }
        print(this + "terminating");
    }

    @Override
    public String toString() {
        return "Server " + id + " ";
    }
    public String shortString() {
        return "T" + id;
    }
}

class SimulationManager implements Runnable {
    private ExecutorService exec;
    private WebClientGenerator gen;
    private WebClientLine clients;
    private Queue<Server> servers = new LinkedList<>();
    private int adjustmentPeriod;
    // Indicates whether the queue is stable
    private boolean stable = true;
    private int prevSize;

    public SimulationManager(ExecutorService exec, WebClientGenerator gen, WebClientLine clients, int adjustmentPeriod, int n) {
        this.exec = exec;
        this.gen = gen;
        this.clients = clients;
        this.adjustmentPeriod = adjustmentPeriod;
        for (int i = 0; i < n; i++) {
            Server server = new Server(clients);
            exec.execute(server);
            servers.add(server);
        }
    }

    public void adjustLoadFactor() {
        // This is actually a control system. By adjusting
        // the numbers , you can reveal stability issues in
        // the control mechanism.
        // if line is stable, increase the 'load factor'
        if (clients.size() > prevSize) {
            if (stable) { // Was stable previous time
                stable = false;
            } else {
                print("Peak load factor: ~" + gen.loadFactor);
                exec.shutdownNow();
            }
        } else {
            print("New load factor: " + ++gen.loadFactor);
            stable = true;
        }
        prevSize = clients.size();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                System.out.println(clients + " { ");
                for (Server server : servers) {
                    printnb(server.shortString() + " ");
                }
                print("}");
                adjustLoadFactor();
            }
        } catch (InterruptedException e) {
            print(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    @Override
    public String toString() {
        return "SimulationManager ";
    }
}
public class E35_WebClientServerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int NUM_OF_SERVERS = 3;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        WebClientLine clients = new WebClientLine(MAX_LINE_SIZE);
        WebClientGenerator g = new WebClientGenerator(clients);
        exec.execute(g);
        exec.execute(new SimulationManager(
                exec, g, clients, ADJUSTMENT_PERIOD, NUM_OF_SERVERS
        ));
        if (args.length > 0) { // Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        } else {
            System.out.println("Press 'ENTER' to quit" );
            System.in.read();
        }
    }
}
