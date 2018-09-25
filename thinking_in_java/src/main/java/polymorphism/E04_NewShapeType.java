package polymorphism;

import polymorphism.newshape.Tetrahedron;
import polymorphism.shape.Circle;
import polymorphism.shape.Shape;
import polymorphism.shape.Square;
import polymorphism.shape.Triangle;

public class E04_NewShapeType {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(), new Square(), new Triangle(), new Tetrahedron()
        };

        //Make polymorphic method calls:
        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
            shape.msg();
        }
    }
}
