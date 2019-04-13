package initialization;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Demonstration of both constructor
 * and ordinary method overloading
 **/
class Tree{
    int height;

    public Tree() {
        print("Planting a seedling");
        height = 0;
    }

    Tree(int initialHeight) {
        height = initialHeight;
        print("Creating new Tree that is " + height + " feet tall");
    }

    void info() {
        print("Tree is " + height + " feet tall");
    }

    void info(String s) {
        print(s + ": tree is " + height + " feet tall");
    }
}

/**
 * @author lh
 */
public class Overloading {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info("overloaded method");
        }
        // Overloaded constructor
        new Tree();
    }
}
