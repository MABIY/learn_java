package access;

import sun.security.provider.Sun;

/**
 * @author lh
 * Demonstrates "prive" keyword
 **/
class Sundae {
    private Sundae() {
    }

    static Sundae makeASundae() {
        return new Sundae();
    }
}
public class IceCream {
    public static void main(String[] args) {
        // Sundae x = new Sundae();
        Sundae x = Sundae.makeASundae();
    }
}
