package polymorphism;

import polymorphism.shape.Circle;
import polymorphism.shape.Shape;
import polymorphism.shape.Square;
import polymorphism.shape.Triangle;

public class E03_NewShapeMethod {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(), new Square(), new Triangle()
        };

        //Make polymorphic method calls:
        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
            shape.msg();
        }
    }
}
