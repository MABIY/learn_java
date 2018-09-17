package reusing;


import reusing.protect.E15_Protected;

class Derived extends E15_Protected {
    public void g() {
        f(); //Accessible in derived class
    }
}
public class E15_ProtectedTest {
    public static void main(String[] args) {
       //! new E15_Protected().f();//Accessible in derived class
        new Derived().g();
    }
}
