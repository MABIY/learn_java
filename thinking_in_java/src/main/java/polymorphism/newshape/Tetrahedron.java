package polymorphism.newshape;

import polymorphism.shape.Shape;

import static access.util.Print.print;

public class Tetrahedron extends Shape {
    @Override
    public void draw() {
        print("Tetrahedron.draw()");
    }

    @Override
    public void erase() {
        print("Tetrahedron.erase()");
    }

    @Override
    public void msg() {
        print("Tetrahedron.msg");
    }
}
