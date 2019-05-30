package generics.decorator;

import java.awt.*;

/**
 * @author lh
 * Create a simple Decorator system by staring
 * with basic coffee, then providing decorators
 * of steamed milk, foam,chocolate, caramel
 * and whipped cream
 **/
class BasicCoffee{
    private String type;

    public BasicCoffee(String type) {
        this.type = type;
    }

    public BasicCoffee() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class CoffeeDecorator extends BasicCoffee {
    protected BasicCoffee basic;

    public CoffeeDecorator(BasicCoffee basic) {
        this.basic = basic;
    }

    @Override
    public void setType(String type) {
        basic.setType(type);
    }

    @Override
    public String getType() {
        return basic.getType();
    }
}

class SteamedMilk extends CoffeeDecorator {
    public SteamedMilk(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & steamed milk");
    }
}

class Foam extends CoffeeDecorator{
    public Foam(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & foam");
    }
}

class Chocolate extends CoffeeDecorator {
    private final Color color;
    public Chocolate(BasicCoffee basic, Color color) {
        super(basic);
        this.color = color;
        setType(getType() + " & chocolate[color = " +
                getColor() + "]");
    }

    public Color getColor() {
        return color;
    }
}

class Caramel extends CoffeeDecorator {
    public Caramel(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & caramel");
    }
}

class WhippedCream extends CoffeeDecorator {
    public WhippedCream(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & whipped cream");
    }
}

public class E38_DecoratorSystem {
    public static void main(String[] args) {
        CoffeeDecorator cappuccino = new Foam(
                new SteamedMilk(new BasicCoffee("espresso"))
        );
        System.out.println(
                "Capuccino is: " + cappuccino.getType()
        );

        CoffeeDecorator whiteChocolateCoffee = new WhippedCream(new Chocolate(
                new BasicCoffee("hot coffee"), Color.WHITE
        ));

        System.out.println("White chocolate Coffeee is: " + whiteChocolateCoffee.getType());
    }
}
