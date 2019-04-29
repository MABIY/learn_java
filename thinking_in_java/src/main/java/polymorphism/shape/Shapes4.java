package polymorphism.shape;

/**
 * @author lh
 **/
public class Shapes4 {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public synchronized static void main(String[] args) {
        Shape[] s = new Shape[10];
        // fill up the array with shapes:
        for (int i = 0; i < s.length; i++) {
            s[i] = gen.next();
        }
        // make polymorphic methods calls:
        for (Shape shp : s) {
            shp.draw();
            shp.erase();
        }
    }

}
