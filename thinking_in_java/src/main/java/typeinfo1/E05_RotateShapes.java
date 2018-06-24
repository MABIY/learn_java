package typeinfo1;

import java.util.Arrays;
import java.util.List;

abstract class RShape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();

    void rorate(int degrees) {
        System.out.println("Rotating " + this +
                " by " + degrees + " degrees");
    }
}

class RCircle extends RShape {
    void rorate(int degrees) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String toString() {
        return "Circle";
    }
}

class RSquare extends RShape {
    @Override
    public String toString() {
        return "Square";
    }
}

class RTriangle extends RShape {
    @Override
    public String toString() {
        return "Triangle";
    }
}
public class E05_RotateShapes {
    static void rotateAll(List<RShape> shapes) {
        for (RShape shape : shapes) {
            if (!(shape instanceof RCircle)) {
                shape.rorate(45);
            }
        }
    }

    public static void main(String[] args) {
        List<RShape> shapes = Arrays.asList(
                new RCircle(), new RSquare(), new RTriangle()
        );

        rotateAll(shapes);
    }
}
