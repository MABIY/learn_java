package operators;

import java.util.Random;

import static org.greggordon.tools.Print.println;

public class CoinToss {
    public static void main(String[] args) {
        Random rand = new Random();
        int coin = rand.nextInt();
        if(coin % 2 ==0) println("heads");
        else println("tails");
    }
}
