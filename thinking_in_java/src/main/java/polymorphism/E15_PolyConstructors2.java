package polymorphism;

import static access.util.Print.print;

class RectangularGlyph extends Glyph {
    private int width = 4;
    private int height = 5;

    public RectangularGlyph(int width, int height) {
        this.width = width;
        this.height = height;
        print("RectangularGlyph.RectangularGlyph(), width = " + width +"" +
                ", height = " + height);
    }

    void draw() {
        print("RectangularGlyph.draw(), area = " + width * height);
    }
}
public class E15_PolyConstructors2 {
    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(2, 2);
    }
}
