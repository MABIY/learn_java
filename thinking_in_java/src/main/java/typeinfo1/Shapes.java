package typeinfo1;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
    public int a =1;
    void draw() {
        System.out.println(this + ".draw()" + this.a);
    }

    abstract public String toString();
}

class Circle extends Shape {
    public int a =2;
    @Override
    public String toString() {
        return "Circle{}";
    }
}

class Square extends Shape{
    public int a =2;
    @Override
    public String toString() {
        return "Square{}";
    }
}

class Triangle extends Shape {
    public int a =2;
    @Override
    public String toString() {
        return "Triangle{}";
    }
}

public class Shapes {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
    }
}
