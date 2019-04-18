package reusing.Ex7;

import org.eclipse.swt.internal.C;

import static net.mindview.util.Print.print;

class A{
    public A(char c, int i) {
        print("A(char,int)");
    }
}
class B extends A{
    public B(String s, float f) {
        super(' ', 0);
        print("B(String,float)");
    }
}
public class C7 extends A{
    private char c;
    private int i;

    C7(char c, int i) {
        super(c, i);
        this.c = c;
        this.i = i;
    }

    B b = new B("hi", 1f); // will then construct another A and then a B

    public static void main(String[] args) {
        C7 c = new C7('b', 2); // will constructor an A first
    }

}
