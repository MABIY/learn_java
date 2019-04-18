package reusing;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Prove the previous sentence.(Even if you don't create a constructor for Cartoon(),
 * the compiler wil syntherize a defualt constructor for you that calls the base-case constructor)
 **/
class Art1{
    public Art1() {
        print("Art constructor");
    }
}

class Drawing1 extends Art{
    public Drawing1() {
        print("Drawing constructor");
    }
}
public class Cartoon2 extends Drawing1 {
    public static void main(String[] args) {
        Cartoon2 x = new Cartoon2();
    }
}
