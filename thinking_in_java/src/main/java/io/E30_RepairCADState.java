package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lh
 * Repair the program CADState.java as descirbed in the text
 **/
abstract class Shape30 implements Serializable {

    private static final long serialVersionUID = -4264461908949202408L;

    public static final int RED = 1,BLUE=2, GREEN = 3;

    private int xPos,yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape30(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() +
                "color[" + getColor() + "] xPos[" + xPos +
                "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape30 randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle30(xVal, yVal, dim);
            case 1:
                return new Square30(xVal, yVal, dim);
            case 2:
                return new Line30(xVal, yVal, dim);
        }
    }
}

class Circle30 extends Shape30 {
    private static int color;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
    public Circle30(int XPos, int yPos, int dimension) {
        super(XPos, yPos, dimension);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square30 extends Shape30 {
    private static int color;
    public Square30(int XPos, int yPos, int dimension) {
        super(XPos, yPos, dimension);
    }

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line30 extends Shape30 {
    private static int color;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public Line30(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}
public class E30_RepairCADState {

    public static final String CADSTATE_OUT = "CADState.out";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Shape30> shapes = new ArrayList<>();
        // Make some shapes:
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape30.randomFactory());
        }
        // Set all the static colors to GREEN:
        for (int i = 0; i < 10; i++) {
            ((Shape30)shapes.get(i)).setColor(Shape.GREEN);
        }
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(CADSTATE_OUT)
        );
        Circle30.serializeStaticState(out);
        Square30.serializeStaticState(out);
        Line30.serializeStaticState(out);
        out.writeObject(shapes);

        // Display the shapes:
        System.out.println(shapes);
        // Now read teh file back in:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(CADSTATE_OUT)
        );
        // Read in the same order they were written:
        Circle30.deserializeStaticState(in);
        Square30.deserializeStaticState(in);
        Line30.deserializeStaticState(in);
        shapes = (List<Shape30>) in.readObject();
    }
}
