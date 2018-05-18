package typeinfo1;

import java.util.Arrays;
import java.util.List;

class Rhomboid extends Shape {
    @Override
    public String toString() {
        return "Rhomboid";
    }
}
public class E03_Rhomboid {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Circle(), new Square(), new Traingle(),
                new Rhomboid()
        );
        for (Shape shape : shapes) {
            shape.draw();
        }
        //UpCast to shape:
        Shape shape = new Rhomboid();
        // Downcast to Rhomboid:
        Rhomboid r = (Rhomboid) shape;
        //Downcast to Circle. Succeeds at compile time.
        //but fails at runtime with a ClassCastException:
        Circle c = (Circle) shape;
    }
}
