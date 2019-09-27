package concurrency;

import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;

import java.util.concurrent.TimeUnit;

/**
 * @author lh
 * Create a non-task class with a method that calls
 * sleep() for a long interval. Create a task that calls
 * the method in the non-task class. In main(), start the
 * task, then call interrupt() to terminate it. Make sure
 * that the task shuts down safely
 */
class NonTask{
    static void longMethod() throws InternalRuntimeError, InterruptedException {
        TimeUnit.SECONDS.sleep(60); // Waits one minute
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        try {
            NonTask.longMethod();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }finally {
            // Any cleanup code here...
        }
    }
}
public class E18_Interruption {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Task());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
