package access;

/**
 * @author lh
 * Create a class with public ,private,protected and package-access fields and
 * method members. Create an object of this class and see what kind of compiler
 * message you ge when you try to access all the class memebrs. Be aware that
 * classes in the same directory are part the "defualt" package.
 **/
public class AccessTest {
    public static void main(String[] args) {
        FourWays fw = new FourWays();
        fw.showa();
        fw.showb();
        fw.showc();
        fw.a = 10;
        fw.b = 20;
        fw.c = 30;
        fw.showa();
        fw.showb();
        fw.showc();
        // fw.showd(); // private  access, compiler can't touch
    }
}
