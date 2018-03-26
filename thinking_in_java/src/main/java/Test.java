import java.util.*;
import java.util.concurrent.*;

class UUIDTest implements Callable<List> {
    @Override
    public List call() throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }
}

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String, Integer> map = new HashMap<>();
        List<Future<List>> a = new ArrayList<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            a.add(exec.submit(new UUIDTest()));
        }
        for (Future<List> item : a) {
            List<String> innerItem = (List<String>) item.get();
            for (String string : innerItem) {
                if (map.get(string) != null) {
                    map.put(string, map.get(string) + 1);
                } else {
                    map.put(string, 0);
                }
            }
        }
        System.out.println(map);
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if (item.getValue() != 0) {
                System.out.println(item);
            }
        }

    }
}
