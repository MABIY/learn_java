package holding;

import java.util.PriorityQueue;

/**
 * @author lh
 * {ThrowsException}
 * Create a simple class that inherits from Object
 * and contains no members, and show that you cannot
 * successfully and multiple elements of that class
 * to a PriorityQueue. this issue will be fully
 * explained in the Containers in Depth chater.
 **/
class Dummy{}
public class E29_PriorityQueueSubtlety {
    public static void main(String[] args) {
        PriorityQueue<Dummy> priorityQueue = new PriorityQueue<>();
        System.out.println("Adding 1st instance...");
        priorityQueue.offer(new Dummy());
        System.out.println("Adding 2nd instance...");
        priorityQueue.offer(new Dummy());
    }
}
