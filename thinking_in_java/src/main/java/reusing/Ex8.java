package reusing;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * create a base class with only a non-defualt constructor, and a derived class
 * with both a default (no-arg) AND non-default constructor. In teh derived-class
 * constructors, call the base-class constructor.
 **/
class A1{
    public A1(char c, int i) {
        print("A(char,int)");
    }
}

public class Ex8 extends A1 {
    private char c;
    private int i;

    public Ex8() {
        super('z', 3);
        print("Ex8()");
    }

    public Ex8(char c, int i) {
        super(c, i);
        this.c = c;
        this.i = i;
        print("Ex8(char,int)");
    }

    public static void main(String[] args) {
        Ex8 ex1 = new Ex8();
        Ex8 ex2 = new Ex8('b', 2);
    }
}
