package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape<T> implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private static Random rand = new Random(47);
    private static int counter = 0;
    private int xPos, yPos, dimension;

    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    public static Shape randomFactry() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);
        }
    }


    public abstract int getColor();

    public abstract void setColor(int newColor);

    @Override
    public String toString() {
        return ""+getClass()+"{" + " color = "+ getColor()+", " +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", dimension=" + dimension +
                '}';
    }
}

class Circle<T> extends Shape {
    private static int color = RED;

    public Circle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

class Square extends Shape {
    private static int color;

    public Square(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

class Line extends Shape {
    private static int color = RED;

    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    public static void serializeStaticState(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

public class StoreCADState {
    public static void main(String[] args) throws IOException {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        // Add references to the class objects
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);
        //TODO 这里为什么可以上面不可以 class 机制不一样 方法参数不检查泛型
        //List<Shape<String>> shapes = new ArrayList<>();
        //shapes.add(new Circle<Integer>(1, 1, 1));
        List<Shape> shapes = new ArrayList<>();
        // Make some shapes:
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactry());
        }
        // Set all the static colors to GREEN:
        for (int i = 0; i < 10; i++) {
            ((Shape) shapes.get(i)).setColor(Shape.GREEN);
        }
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("CADState.out")
        );
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        System.out.println(shapes);
    }
}
