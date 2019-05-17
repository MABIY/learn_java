package typeinfo;

import static net.lh.util.Print.print;

/**
 * Modify SweetShop.java so that each type of object
 * creation is controlled by a command-line argument. That is , if you
 * command line is "java SweetShop Candy," then
 * only the Candy object is created. NOtice how
 * you can control which Class objects are loaded
 * via the command-line argument
 **/
class Candy7{
    static {
        print("Loading Candy7");
    }
}
class Gum7{
    static {
        print("Loading Gum");
    }
}

class Cookie7{
    static {
        print("Loading Cookie");
    }
}
public class E07_CommandLoad {
    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"typeinfo.Gum7","typeinfo.Cookie7"};
        for (String arg : args) {
            Class.forName(arg);
        }
    }
}
