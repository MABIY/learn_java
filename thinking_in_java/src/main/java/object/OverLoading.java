package object;

/**
 * creates type Tree wth two constructors and on info method
 */
class Tree{
    int height;

    /**
     * no-argument constructor
     * assigns height = 0
     */
    public Tree() {
    }

    public Tree(int initialHeight) {
        this.height = initialHeight;
        System.out.println("Creating new tree that is " + height + " feet tall");
    }

    /**
     * method to print height of tree object
     */
    void info() {
        System.out.println("Tree is " + height + " feet tall");
    }

    void info(String s) {
        System.out.println(s + ": Tree is " + height + " feet tall");
    }
}

/**
 * class to test construction of tree objects
 */
public class OverLoading {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloading method");
        }

        // Overloading constructor:
        new Tree();
    }
}
