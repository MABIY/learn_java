package innerclasses;

import static net.mindview.util.Print.print;

interface Incrementable {
    void increment();
}

//Very simple to just implement the interface:
class Callee1 implements Incrementable {
    private int i;

    @Override
    public void increment() {
        i++;
        print(i);
    }
}

class MyIncrement {
    static void f(MyIncrement mi) {
        mi.increment();
    }

    public void increment() {
        print("Other operation");
    }
}

//If your class must implement increment() in
// some other way, you must use a inner class:
class Callee2 extends MyIncrement {
    private int i;

    public void increment() {
        super.increment();
        i++;
        print(i);
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }

    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
}

class Caller {
    private Incrementable callbackReference;

    public Caller(Incrementable callbackReference) {
        this.callbackReference = callbackReference;
    }

    void go() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
