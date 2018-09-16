package reusing;

import static org.greggordon.tools.Print.println;

class Art2{
    Art2() {
        println("Art constructor");
    }

}

class Drawing2 extends Art2{
    public Drawing2() {
        println("Drawing2 constructor");
    }
}
public class Cartoon2 extends Drawing2{
    public static void main(String[] args) {
        Cartoon2 x = new Cartoon2();
    }
}
