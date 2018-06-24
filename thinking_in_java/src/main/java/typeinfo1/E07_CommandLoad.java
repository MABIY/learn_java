package typeinfo1;

class Candy7 {
    static {
        System.out.println("Loading Candy");
    }
}

class Gm7 {
    static {
        System.out.println("LOading Gum");
    }
}

class Cookie7 {
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
