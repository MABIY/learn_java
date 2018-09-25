package polymorphism.shape;

import static access.util.Print.print;

public class Circle extends Shape {
    @Override
    public void draw() {
        print("Cirlce.draw()");
    }

    @Override
    public void erase() {
        print("Circle.erase()");
    }

    public void msg() {
        print("Circle.msg()");
    }
}
