package concurrency;

import javax.lang.model.type.ExecutableType;
import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String> {
    @Override
    public String call() throws Exception {
        return null;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult()));
        }
        for (Future<String> fs : results) {
            try {
                // get() blocks until completion:
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }
}
