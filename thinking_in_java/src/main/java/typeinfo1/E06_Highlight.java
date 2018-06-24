package typeinfo1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class A {
    public static void a() {
    }

    public void e() {

    }
}
interface B {
     static void b() {

    }

    public void d();
}
class HShape extends A implements B{
    boolean highlighted = false;
    public void highlight() {
        highlighted = true;
    }

    public static String t() {
        return "";
    }
    static String c() {
        return "";
    }
    public void clearHighlight() {
        highlighted = false;
    }

    public void draw() {
        System.out.println(this + " draw()");
    }

    @Override
    public String toString() {
        return getClass().getName() + (highlighted ? " highlighted" : " normal");
    }

    static List<HShape> shapes = new ArrayList<>();
    HShape(){
        shapes.add(this);
    }

    // Basic apprach (code duplication)
    static void highlight1(Class<?> type) {
        for (HShape shape : shapes) {
            if (type.isInstance(shape)) {
                shape.highlight();
            }
        }
    }

    static void clearHighlight1(Class<?> type) {
        for (HShape shape : shapes) {
            if (type.isInstance(shape)) {
                shape.clearHighlight();
            }
        }
    }

    static void forEach(Class<?> type, String method) {
        try {
            Method m = HShape.class.getMethod(method, (Class<?>[]) null);
            for (HShape shape : shapes) {
                if (type.isInstance(shape)) {
                    m.invoke(shape, null);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void highlight2(Class<?> type) {
        forEach(type,"highlight");
    }

    static void clearHighlight2(Class<?> type) {
        forEach(type, "clearHighlight");
    }

    @Override
    public void d() {

    }
}

class Hcircle extends HShape { }
class HSquare extends HShape{}
class HTriangle extends HShape{}

public class E06_Highlight {
    public static void main(String[] args) {
        List<HShape> shapes = Arrays.asList(
                new Hcircle(), new HSquare(),
                new HTriangle(), new HSquare(),
                new HTriangle(), new Hcircle(),
                new Hcircle(), new HSquare()
        );
        HShape.highlight1(Hcircle.class);
        HShape.highlight2(Hcircle.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
        System.out.println("**********");
        //HIghlight them all:
        HShape.highlight1(HShape.class);
        HShape.highlight2(HShape.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
        System.out.println(" * * * * * * * * * *");
        // Not in the hierarchy
        HShape.clearHighlight1(ArrayList.class);
        HShape.clearHighlight2(ArrayList.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
    }
}
