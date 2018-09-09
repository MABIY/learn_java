package operators;

import static org.greggordon.tools.Print.println;

public class CastingNumbers {
    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        println("(int)above: " + (int) above);
        println("(int)ablow: " + (int) below);

        println("(int)fabove: " + (int) fabove);
        println("(int)fablow: " + (int) fbelow);
    }
}
