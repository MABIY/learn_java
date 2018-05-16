package typeinfo1;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
    public String a ="Shape.a";

    void draw() {
        System.out.println(this + ".draw()" +this.a);
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String a = "sub.a";
    @Override
    public String toString() {
        return "Circle{}";
    }
}

class Square extends Shape {
    public String a = "sub.a";
    @Override
    public String toString() {
        return "Square{}";
    }
}

class Traingle extends Shape {
    public String a = "sub.a";
    @Override
    public String toString() {
        return "Traingle{}";
    }
}

public class Shapes {
    public String a = "sub.a";
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Traingle());
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }
}
