package reusing.Ex5;

import org.eclipse.swt.internal.C;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Using chess.java,prove the statements in the previous paragraph. (if you
 * don't call the base call constructor in BoardGame(), the compiler will
 * complain that it can't find a constructor of the form Game(). In addition,
 *  the call to the base-class constructor must be the first thin you do in the
 *  derived-class constructor, the compiler will remind you if you get it wrong.
 **/
class Game1{
    public Game1(int i) {
        print("Game constructor");
    }
}

class BoardGame1 extends Game1 {
    public BoardGame1(int i) {
        // print("BoardGame constructor"); //  call to super must be first
        // statement in constructor
        super(i);
        print("BoardGame constructor");
    }
}

public class Chess1 extends BoardGame1 {
    public Chess1() {
        super(11);
        print("Chess constructor");
    }

    public static void main(String[] args) {
        Chess1 x = new Chess1();
    }
}
