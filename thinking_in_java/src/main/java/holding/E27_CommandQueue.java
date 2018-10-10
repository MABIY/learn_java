package holding;

import java.util.LinkedList;
import java.util.Queue;

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

class Consumer {
    public static void consumer(Queue<Command> q) {
        while (q.peek() != null) {
            q.remove().operation();
        }
    }
}
public class E27_CommandQueue {
    public static void main(String[] args) {
        Queue<Command> cmds = new LinkedList<>();
        Producer.produce(cmds);
        Consumer.consumer(cmds);
    }
}
