package innerclasses;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify the solution to Exercise 19 from the Interface chapter to use
 * anonymous inner classes.
 * (Exercise 19, Interfaces: Create a framework using Factory Methods
 * that performs both coin tossing and dice tossing)
 **/
interface Games1 {
    void play();
}

interface GamesFactory {
    Games1 getGames();
}

class CoinToss implements Games1 {
    Random rand = new Random();

    @Override
    public void play() {
        print("Toss Coin: ");
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

    public static GamesFactory factory = new GamesFactory() {
        @Override
        public Games1 getGames() {
            return new CoinToss();
        }
    };
}

class DiceThrow implements Games1{
    Random rand = new Random();

    @Override
    public void play() {
        print("Throw Dice: " + (rand.nextInt(6) + 1));
    }

    public static GamesFactory factory = new GamesFactory() {
        @Override
        public Games1 getGames() {
            return new DiceThrow();
        }
    };
}

public class Games17 {
    public static void playGame(GamesFactory factory) {
        Games1 g = factory.getGames();
        g.play();
    }

    public static void main(String[] args) {
        playGame(CoinToss.factory);
        playGame(DiceThrow.factory);
    }
}
