package reusing;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Constructor calls during inheritance
 **/

class Art{
   Art() {
       print("Art constructor");
   }
}

class Drawing extends Art {
    public Drawing() {
        print("Drawing constructor");
    }
}

public class Cartoon extends Drawing1 {
    public Cartoon() {
        print("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
