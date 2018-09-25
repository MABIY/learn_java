package polymorphism;

import static access.util.Print.print;

class Glyph{
    void draw() {
        print("Glyph.draw()");
    }
    private void a() {
        System.out.println("a");
    }

    public Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;

    public RoundGlyph(int r) {
        this.radius = r;
        print("RoundGlyph.RoundGlyph() , radius = " + radius);
    }

    void draw() {
        print("RoundgLYPH.DRAW(), RADIUS = " + radius);
    }
}
public class Polyconstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
