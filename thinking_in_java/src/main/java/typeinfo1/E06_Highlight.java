package typeinfo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface A1{
}
class HShape {
    boolean highlighted = false;
    public String a = "tt";

    public void highlight() {
        highlighted = true;
    }
    public void clearHighlight() {
        highlighted = false;
    }
    void draw() {
        System.out.println(this + " draw()");
    }

    @Override
    public String toString() {
        return getClass().getName() + (highlighted ? " highlighted" : " normal");
    }

    static List<HShape> shapes = new ArrayList<>();

    HShape() {
        //todo  先看第五章 初始化和清理
        shapes.add(this);
    }

    // Basic approach (code duplication)
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
            Method m = HShape.class.getMethod(method, null);
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
        forEach(type, "highlight");
    }

    static void clearHighlight2(Class<?> type) {
        forEach(type, "clearHighlight");
    }
}

class HCircle extends HShape {
    public String a = "Circle";
}

class HSquare extends HShape{
    public String a = "HSquare";
}

class HTriangle extends HShape{
    public String a = "HTriangle";
}

public class E06_Highlight {
    public static void main(String[] args) {
        List<HShape> shapes = Arrays.asList(
                new HCircle(), new HSquare(),
                new HTriangle(), new HSquare(),
                new HTriangle(), new HCircle(),
                new HCircle(), new HSquare()
        );
        HShape.highlight1(HCircle.class);
        HShape.highlight1(HCircle.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
        System.out.println("**********");
        //Highlight them all:
        HShape.highlight1(HShape.class);
        HShape.highlight2(HShape.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
        System.out.println("**********");
        // NOt in the hierarchy
        HShape.clearHighlight1(ArrayList.class);
        HShape.clearHighlight2(ArrayList.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
    }
}
