package generics;

import java.awt.*;
import java.util.Random;

/**
 * @author lh
 * Add a mixin class Colored to Mixins.java,
 * mix it in to Mixin, and show that it works.
 **/

interface Colored37{
    Color getColor();
}

class ColoredImp implements Colored37{
    private static Random rnd = new Random(47);
    private final Color clr = new Color(rnd.nextInt(16777216));
    @Override
    public Color getColor() {
        return clr;
    }
}

class Mixin2 extends Mixins implements Colored37 {
    private Colored37 colored = new ColoredImp();
    @Override
    public Color getColor() {
        return colored.getColor();
    }
}

public class E37_Mixins2 {
    public static void main(String[] args) {
        Mixin2 mixin1 = new Mixin2(), mixin2 = new Mixin2();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " + mixin1.getStamp()+ " "
        +mixin1.getSerialNumber() + " " + mixin1.getColor());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " "
        + mixin2.getSerialNumber() + " " + mixin2.getColor());
    }
}
