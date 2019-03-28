package operators;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Write a program that simulates conin
 **/
public class CoinToss {
    public static void main(String[] args) {
        Random rand = new Random();
        int coin = rand.nextInt();
        if (coin % 2 == 0) {
            print("heads");
        } else {
            print("tails");
        }
    }
}
