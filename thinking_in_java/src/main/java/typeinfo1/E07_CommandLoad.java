package typeinfo1;

class Candy_07 {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum_07 {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie_07 {
    static {
        System.out.println("Loading Cookie");
    }
}

public class E07_CommandLoad {
    public static void main(String[] args) throws ClassNotFoundException {
        for (String arg : args) {
            Class.forName(arg);
        }
    }
}
