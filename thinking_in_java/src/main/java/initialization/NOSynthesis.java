package initialization;

/**
 * @author lh
 **/
class Bird2{
    public Bird2(double d) {
    }
    public Bird2(int i) {
    }
}
public class NOSynthesis {
    public static void main(String[] args) {
        // Bird2 b = new Bird2(); //  No defualt
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
    }
}
