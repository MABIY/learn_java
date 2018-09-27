package interfaces;

import polymorphism.Sandwich;

import static access.util.Print.print;

interface FastFood{
    void rushOrder();

    void gobble();
}

class FastSandwish extends Sandwich implements FastFood {
    @Override
    public void rushOrder() {
        print("Rushing your sandwish order");
    }

    @Override
    public void gobble() {
        print("Chomp! Snort! Gobble!");
    }
}
public class E08_FastFood {
    public static void main(String[] args) {
        FastSandwish burger = new FastSandwish();
        print("Fries with taht?");
        print("Super Size?");
        burger.rushOrder();
        burger.gobble();
    }
}
