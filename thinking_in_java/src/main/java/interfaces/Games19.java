package interfaces;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Create a framework using Factroy Methods that performs both coin
 * tossing and dice tossing
 **/
interface Games1 {
    void play();
}

interface Games1Factory {
    Games1 getGames();
}

class CoinToss implements Games1 {
    Random rand = new Random();

    @Override
    public void play() {
        print("Toss Coin:");
        switch (rand.nextInt(2)) {
            case 0:
                print("Heads");
                return;
            case 1:
                print("Tails");
                return;
            default:
                print("OnEdge");
                return;
        }
    }
}

class CoinTossFactory implements Games1Factory {
    @Override
    public Games1 getGames() {
        return new CoinToss();
    }
}

class DiceThrow implements Games1 {
    Random rand = new Random();

    @Override
    public void play() {
        print("Throw Dice: " + (rand.nextInt(6) + 1));
    }
}

class DiceThrowFactory implements Games1Factory {
    @Override
    public Games1 getGames() {
        return new DiceThrow();
    }
}

public class Games19 {
    public static void playGame(Games1Factory factory) {
        Games1 g = factory.getGames();
        g.play();
    }
    public static void main(String[] args){
        playGame(new CoinTossFactory());
        playGame(new DiceThrowFactory());
    }
}
