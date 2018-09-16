package reusing;

import static org.greggordon.tools.Print.println;

class A8{
    A8(char c, int i) {
        println("A(char,int)");
    }
}
public class Ex8 extends A8{
    private char c;
    private int i;

    public Ex8() {
        super('z', 3);
        println("Ex8()");
    }

    public Ex8(char c, int i){
        super(c, i);
        this.c = c;
        this.i = i;
    }

    public static void main(String[] args) {
        Ex8 ex1 = new Ex8();
        Ex8 ex2 = new Ex8('b',2);
    }
}
