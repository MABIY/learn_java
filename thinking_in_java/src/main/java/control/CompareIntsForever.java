package control;

import java.util.Random;

import static org.greggordon.tools.Print.println;

public class CompareIntsForever {
    public static void main(String[] args) {
        Random rand1 = new Random();
        Random rand2 = new Random();
        for (int i = 0; i < 25; i++) {
            int x = rand1.nextInt();
            int y = rand2.nextInt();
            if (x < y) {
                println(x + " < " + y);
            } else if (x > y) {
                println(x + " > " + y);
            } else {
                println(x + " = " + y);
            }
        }

        Random rand3 = new Random();
        Random rand4 = new Random();
        while (true) {
            for (int i = 0; i < 25; i++) {
                int x = rand3.nextInt();
                int y = rand4.nextInt();
                if (x < y) {
                    println(x + " < " + y);
                } else if (x > y) {
                    println(x + " > " + y);
                } else {
                    println(x + " = " + y);
                }
            }
        }
    }
}
