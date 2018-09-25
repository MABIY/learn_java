package polymorphism;

import static access.util.Print.print;

class Pickle{
    public Pickle() {
        print("Pickle()");
    }
}

class Sandwich2 extends PortableLunch {
    Bread b = new Bread();
    Cheese c = new Cheese();
    Lettuce l = new Lettuce();
    Pickle p = new Pickle();
    Sandwich2(){
        print("Sandwish()");
    }
}
public class E11_Pickle {
    public static void main(String[] args) {
        new Sandwich2();
    }
}
