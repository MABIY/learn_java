package reusing;

import static org.greggordon.tools.Print.println;

class A7{
    public A7(char c, int i) {
        println("A(char,int)");
    }
}

class B7 extends A7 {
    public B7(String c, float i) {
        super(' ', 0);
        println("B(String,float)");
    }
}

public class C7 extends A7 {
    private char c;
    private int i;
    public C7(char c, int i) {
        super(c, i);
        this.c = c;
        this.i = i;
    }
    B7 b = new B7("hi",1f); //will then construct another A7 and then a B7

    public static void main(String[] args) {
        C7 c = new C7('b', 2); // will construct an A first
    }
}
