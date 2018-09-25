package polymorphism.shape;

import static access.util.Print.print;

public class Square extends Shape {
    @Override
    public void draw() {
        print("Square.draw()");
    }

    @Override
    public void msg() {
        print("Square.msg()");
    }

    @Override
    public void erase() {
        print("Square.erase()");
    }
}
