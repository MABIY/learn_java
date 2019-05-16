package typeinfo;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Examination of the way the class loader works
 **/
class Candy{
    static {
        print("Loading Candy");
    }
}

class Gum{
    static {
        print("Loading Gum");
    }
}

class Cookie{
    static {
        print("Loading Cookie");
    }
}
public class SweetShop {
    public static void main(String[] args) {
        print("indise main");
        new Candy();
        print("After creating Cnady");
        try {
            Class.forName("typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }
}
