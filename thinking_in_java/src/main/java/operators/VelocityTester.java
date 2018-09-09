package operators;

class VelocityCalculator {
    static float velocity(float d, float t) {
        if (t == 0) return 0f;
        else return d / t;
    }
}

public class VelocityTester {
    public static void main(String[] args) {
        float d = 565.3f;
        float t = 3.6f;
        System.out.println("Distance: " + d);
        System.out.println("Time: " + t);
        float v = VelocityCalculator.velocity(d, t);
        System.out.println("Velocity: " + v);
    }
}
