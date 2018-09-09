package operators;

import static org.greggordon.tools.Print.println;

public class RoundingNumbers {
    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        println("Math.round(above): " + Math.round(above));
        println("Math.round(below): " + Math.round(below));
        println("Math.round(fabove): " + Math.round(fabove));
        println("Math.round(fbelow): " + Math.round(fbelow));
    }
}
