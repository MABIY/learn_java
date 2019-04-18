package reusing.Ex5;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Inheritance ,constructors and arguments
 **/
class Game{
    public Game(int i) {
        print("Game constructor");
    }
}

class BoardGame extends Game{
    public BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    public Chess() {
        super(11);
        print("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
