package polymorphism;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Add a RectangularGlyph to PolyConstructors.java and demonstrate the problem
 * described in this section
 **/
class Glyph15 {
    public Glyph15() {
        print("Glyph.draw()");
        draw();
        print("Glyph() after draw()");
    }

    void draw() {
        print("Glyph.draw()");
    }
}

class RoundGlyph15 extends Glyph15 {
    private int radius = 1;

    public RoundGlyph15(int radius) {
        this.radius = radius;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph15 extends Glyph15 {
    private int length = 2;
    private int width = 4;

    public RectangularGlyph15(int length, int width) {
        this.length = length;
        this.width = width;
        print("RectangularGlyph.RectangularGlyph(), length = "
                + length + ", width = " + width);
    }

    @Override
    void draw() {
        print("RectangularGlyph.draw(), length = " + length + ", width = " + width);
    }
}
public class PolyConstructors15 {
    public static void main(String[] args) {
        new RoundGlyph15(5);
        new RectangularGlyph15(3, 6);
    }
}
