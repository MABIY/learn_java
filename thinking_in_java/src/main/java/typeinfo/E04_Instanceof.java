package typeinfo;

/**
 * Modify the previous exercise so that it uses
 * instanceof to check the type before preforming
 * the downcast
 **/
public class E04_Instanceof {
    public static void main(String[] args) {
        // Upcast to shape:
        Shape shape = new Rhomboid5();
        // Downcast to Rhomboid:
        Rhomboid5 r = (Rhomboid5) shape;
        // Test before DownCasting:
        Circle c = null;
        if (shape instanceof Circle) {
            c = (Circle) shape;
        } else {
            System.out.println("shape not a Circle");
        }
    }
}
