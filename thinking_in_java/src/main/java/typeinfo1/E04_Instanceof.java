package typeinfo1;

public class E04_Instanceof {
    public static void main(String[] args) {
        //Upcast to shape
        Shape shape = new Rhomboid();
        //Downcast to Rhomboid
        Rhomboid r = (Rhomboid) shape;
        //Test before Downcasting:
        Circle c = null;
        if (shape instanceof Circle) {
            c = (Circle) shape;
        } else {
            System.out.println("shape not a Circle");

        }
    }
}
