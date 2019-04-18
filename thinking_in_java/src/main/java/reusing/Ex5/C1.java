package reusing.Ex5;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Create two classes ,A and B with defualt constructors (empty arugment lists)
 * that announce themselves,Inherit a new class called  C from A, and
 * create a member of class B inside C. Do not create a constructor for C . Create
 * an object of class C and observe the results
 **/
class A1 {
    public A1() {
        print("A()");
    }
}

class B1 extends A1 {
    public B1() {
        print("B1()");
    }
}

public class C1 extends A1 {
    B1 b = new B1(); // will then construct another A and a B

    public static void main(String[] args) {
        C1 c = new C1();
    }
}
