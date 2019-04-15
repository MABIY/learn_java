package initialization;

/**
 * @author lh
 * Create a class with a constructor that takes a String argument.During
 * constriction,print the arugment,Create and array of object references to this
 * class,but don't actually create objects to assign into the array.when you run
 * the program,notice whether the initialization message from the constructor
 * are printed
 **/

class InitTest{
    public InitTest(String s) {
        System.out.println("InitTest()");
        System.out.println(s);
    }
}
public class InitTest17 {
    public static void main(String[] args) {
        InitTest[] it = new InitTest[10];
    }
}
