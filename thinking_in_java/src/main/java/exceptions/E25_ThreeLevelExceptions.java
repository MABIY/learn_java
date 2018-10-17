package exceptions;

class Level1Exception extends Exception {
}

class Level2Exception extends Level1Exception {

}

class Level3Exception extends Level2Exception {
}

class A{
    public void f() throws Level1Exception {
        throw new Level1Exception();
    }
}

class B extends A {
    public void f() throws Level2Exception {
        throw new Level2Exception();
    }
}

class C extends B {
    @Override
    public void f() throws Level3Exception {
        throw new Level3Exception();
    }
}
public class E25_ThreeLevelExceptions {

    public static void main(String[] args) {
        A a = new C();
        try {
            a.f();
        } catch (Level1Exception e) {
            System.out.println("Caught " + e);
        }
    }
}
