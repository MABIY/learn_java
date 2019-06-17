package containers;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author lh
 * Create a class that contians an Integer is initialized to a value
 * between 0 and 100 using
 * java.util.Random. Implement Comparable using this
 * Integer field.Fill a PriorityQueue with objects of
 * your class. and extract the values using poll() to
 * show that it proeduces the expected order.
 **/
class Item implements Comparable<Item>{
    private static final Random rnd = new Random(47);
    private Integer priority = rnd.nextInt(101);

    @Override
    public int compareTo(Item o) {
        return priority < o.priority ? -1 : priority.equals(o.priority) ? 0 : 1;
    }

    @Override
    public String toString() {
        return Integer.toString(priority);
    }
}
public class E11_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Item> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.add(new Item());
        }
        Item item;
        while ((item = queue.poll()) != null) {
            System.out.println(item);
        }
    }
}
