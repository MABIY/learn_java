package reusing;

import static access.util.Print.print;

class Game6 {
    public Game6(int i) {
        print("Game constructor");
    }
}

class BoardGame6 extends Game6 {
    public BoardGame6(int i) {
        // print("BoardGame constructor");//call to super must be first
        // statement in constructor
        super(i);
        print("BoardGame construcotr");
    }
}

public class Chess extends BoardGame6 {
    public Chess() {
        super(11);
        print("Chess construcotr");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
