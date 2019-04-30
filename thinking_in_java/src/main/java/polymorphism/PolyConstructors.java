package polymorphism;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Constructors and polymorphism
 * don't produce what you might expect
 **/
class Glyph{
    void draw() {
        print("Glyph.draw()");
    }

    public Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }

}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    @Override
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
