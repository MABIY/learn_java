package reusing;

import control.LabeledFor;

class LoadTest{
    //The static clause is executed
    //upon class loading
    static {
        System.out.println("Loading LoadTest");
    }

    static void staticMember() {
    }
}
public class E23_ClassLoading {
    public static void main(String[] args) {
        System.out.println("Calling static member");
        new LoadTest();
        System.out.println("Creating an object");
        LoadTest.staticMember();
    }
}
