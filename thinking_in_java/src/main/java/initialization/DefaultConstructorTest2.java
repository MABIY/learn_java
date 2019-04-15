package initialization;

/**
 * @author lh
 * Add an overloaded constructor to the previous exercise that take a String argument
 * and print it along with your message
 **/
class Kabayo2{
    public Kabayo2() {
        System.out.println("isa long kaboyo");
    }

    Kabayo2(String s) {
        System.out.println(s);
    }
}
public class DefaultConstructorTest2 {
    public static void main(String[] args) {
        Kabayo2 k = new Kabayo2();
        Kabayo2 k2 = new Kabayo2("tumutugtog ng gitara");
    }
}
