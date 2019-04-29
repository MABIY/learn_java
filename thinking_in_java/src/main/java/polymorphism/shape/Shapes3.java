package polymorphism.shape;

/**
 * @author lh
 * Add a new method in the base clas of Shapes.java that prints a message, but
 * don't override it in the derived classes.Explain what happens. now override
 * it in one of the derived classes but not the others and see what happens.
 * Finally override it in all the derived classes.
 **/
public class Shapes3 {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[10];
        // fill up the array with shapes
        for (int i = 0; i < s.length; i++) {
            s[i] = gen.next();
        }
        // make polymophic methods calls
        for (Shape shp : s) {
            shp.draw();
            shp.erase();
        }
    }
}
