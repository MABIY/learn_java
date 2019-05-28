package generics;

import java.awt.*;

/**
 * @author lh
 **/
class HoldItem<T>{
    T item;

    public HoldItem(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
}

class Colored2<T extends HasColor> extends HoldItem<T> {
    public Colored2(T item) {
        super(item);
    }
    Color color() {
        return item.getColor();
    }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T>{
    public ColoredDimension2(T item) {
        super(item);
    }
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T>{
    public Solid2(T item) {
        super(item);
    }
}

public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
    }
}
