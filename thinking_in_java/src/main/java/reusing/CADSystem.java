package reusing;

import static net.mindview.util.Print.print;

class Shape{
    public Shape(int i) {
        print("Shape constructor");
    }

    void dispose() {
        print("Shape dispose");
    }
}

class Circle extends Shape{
    public Circle(int i) {
        super(i);
        print("Drwaing Circle");
    }

    void dispose() {
        print("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    public Triangle(int i) {
        super(i);
        print("Drawing Triangle");
    }

    void dispose() {
        print("Drasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start , end;

    public Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing Line: " + start + ", " + end);
    }
    void dispose() {
        print("Erasing Line: " + start + ", " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape{
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];
    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j * j);
        }
        c = new Circle(1);
        t = new Triangle(1);
        print("Combined constructor");
    }

    public void dispose() {
        print("CADSystem.dispose()");
        //The order of cleanup is the reverse
        // of the order of initialization:
        t.dispose();
        c.dispose();
        for (int i = lines.length -1; i >=0; i--) {
            lines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        try {
            //Code and exception handling...
        }finally {
            x.dispose();
        }
    }
}
