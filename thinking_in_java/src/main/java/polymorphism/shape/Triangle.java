package polymorphism.shape;

import static access.util.Print.print;

public class Triangle extends Shape{
    @Override
    public void draw() {
        print("Triangle.draw()");
    }

    @Override
    public void msg() {
        print("Triangle.msg()");
    }

    @Override
    public void erase() {
        print("Triangle.erase()");
    }
}
