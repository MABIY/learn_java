package typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Add Rhomboid to Shapes.java. Create a
 * Rhomboid, upcast it to a Shape, then downcast
 * it back to a Rhomboid. Try downcasting to a
 * Circle and see what happens
 **/
class Rhomboid5 extends Shape {
    @Override
    public String toString() {
        return "Rhomboid5";
    }
}

public class E03_Rhomboid {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Circle(), new Square(), new Triangle(),
                new Rhomboid5()
        );
        for (Shape shape : shapes) {
            shape.draw();
        }
        // Upcast to shape:
        Shape shape = new Rhomboid5();
        // Downcast to Rhomboid:
        Rhomboid5 r = (Rhomboid5) shape;
        //Downcast to Circle, Succeeds at compile time,
        // but fails at runtime with a ClassCastException:
        // Circle c = (Circle) shape;
    }
}
