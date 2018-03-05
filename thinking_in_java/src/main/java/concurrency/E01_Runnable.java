package concurrency;

class Printer implements Runnable {
    private static int taskCount;
    private final int id = taskCount++;
    Printer() {

    }
    @Override
    public void run() {
        System.out.println("Stage 1... ID = " + id);
        Thread.yield();

        System.out.println("Stage 2... ID = " + id);
        Thread.yield();
        System.out.println("Stage 3... ID = " + id);
        Thread.yield();
        System.out.println("Printer ended, ID = " + id);
    }
}
public class E01_Runnable {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Printer()).start();
        }
    }
}
