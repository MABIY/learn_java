package holding;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lh
 * Write a class called Command that contains a
 * String and has a method operation() that
 * displays the String. Write a second class with
 * a method that fills a Queue with command objects
 * and returns it. Pass the filled Queue to a method
 * in a third class that consumes the objects in the
 * Queue and calls their operaton() methods.
 **/

class Command{
    private final String cmd;

    public Command(String cmd) {
        this.cmd = cmd;
    }
    public void operation() {
        System.out.println(cmd);
    }
}
class Producer{
    public static void produce(Queue<Command> q) {
        q.offer(new Command("load"));
        q.offer(new Command("delete"));
        q.offer(new Command("save"));
        q.offer(new Command("exit"));
    }
}
class Consumer{
    public static void consume(Queue<Command> q) {
        while (q.peek() != null) {
            q.remove().operation();
        }
    }
}
public class E27_CommandQueue {
    public static void main(String[] args) {
        Queue<Command> cmds = new LinkedList<>();
        Producer.produce(cmds);
        Consumer.consume(cmds);
    }
}
