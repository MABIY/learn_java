package operators;

import static org.greggordon.tools.Print.println;

class Tube{
    float level;
}
public class Assign {
    public static void main(String[] args) {
        Tube t1 = new Tube();
        Tube t2 = new Tube();
        t1.level = 0.9f;
        t2.level = 0.47f;
        println("1: t1.level: " + t1.level + ", t2.level: " + t2.level);
        t1 = t2;
        println("2: t1.level: " + t1.level + ", t2.level: " + t2.level);
        t1.level = 0.27f;
        println("3: t1.level: " + t1.level + ", t2.level: " + t2.level);
    }
}
