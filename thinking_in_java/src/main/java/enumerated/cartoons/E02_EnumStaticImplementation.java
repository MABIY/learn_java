package enumerated.cartoons;

import java.util.Random;

/**
 * @author lh
 * ******************************
 * Instead of implementing an interface,
 * ******************************
 */
enum CartoonCharacter2{
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
    private static Random rand = new Random(47);
    public static CartoonCharacter2 next() {
        return values()[rand.nextInt(values().length)];
    }
}
public class E02_EnumStaticImplementation {
    public static void printNext() {
        System.out.println(CartoonCharacter2.next() + ", ");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printNext();
        }
    }
}
