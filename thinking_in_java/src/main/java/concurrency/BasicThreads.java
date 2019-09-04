package concurrency;

/**
 * @author lh
 * The most basic use of hte Thead class.
 */
public class BasicThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new LiftOff());
        t.start();
        Thread.sleep(10000);
        System.out.println("te");
    }
}
