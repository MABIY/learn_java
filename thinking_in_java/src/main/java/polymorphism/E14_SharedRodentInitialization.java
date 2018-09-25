package polymorphism;

import static access.util.Print.print;

class NonSharedMemebr {
    public NonSharedMemebr(String id) {
        print("Non shared member constructor " + id);
    }
}

class SharedMember {
    private int refcount;

    public SharedMember() {
        print("Shared member constructor");
    }

    public void addRef() {
        print("Number of references " + ++refcount);
    }

    protected void dispose() {
        if (--refcount == 0) {
            print("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "SharedMember{" +
                '}';
    }
}

class Rodent3 {
    NonSharedMemebr m1 = new NonSharedMemebr("r1"), m2 =
            new NonSharedMemebr("r2");
    private SharedMember m;

    public Rodent3(SharedMember sm) {
        print("Rodent constructor");
        m = sm;
        m.addRef();
    }

    public void hop() {
        print("Rodent hopping");
    }

    public void scurry() {
        print("Rodent scurrying");
    }

    public void reproduce() {
        print("Making more Rodents");
    }

    protected void dispose() {
        print("Disposing " + this);
        m.dispose();
    }

    @Override
    public String toString() {
        return "Rodent";
    }
}

class Mouse3 extends Rodent3 {
    NonSharedMemebr m1 = new NonSharedMemebr("m1");
    NonSharedMemebr m2 = new NonSharedMemebr("m2");

    public Mouse3(SharedMember sm) {
        super(sm);
        print("Mouse constructor");
    }

    public void hop() {
        print("Mouse hopping");
    }

    public void scurry() {
        print("Mouse scurrying");
    }

    public void reproduce() {
        print("Making more mice");
    }

    @Override
    public String toString() {
        return "Mouse";
    }
}

class Gerbil3 extends Rodent3 {
    NonSharedMemebr m1 = new NonSharedMemebr("g1"),
            m2 = new NonSharedMemebr("g1");
    private SharedMember m;

    public Gerbil3(SharedMember sm) {
        super(sm);
        print("Gerbil constructor");
    }

    @Override
    public void hop() {
        print("Gerbil hopping");
    }

    @Override
    public void scurry() {
        print("Gerbil scurrying");
    }

    @Override
    public void reproduce() {
        print("Making more Gerbils");
    }

    @Override
    public String toString() {
        return "Gerbil";
    }
}

class Hamster3 extends Rodent3 {
    private SharedMember m;
    NonSharedMemebr m1 = new NonSharedMemebr("h1"),
            m2 = new NonSharedMemebr("h2");
    public Hamster3(SharedMember sm) {
        super(sm);
        print("Hamster constructor");
    }

    @Override
    public void hop() {
        print("Hamster hopping");
    }

    @Override
    public void scurry() {
        print("Hamster scurrying");
    }

    @Override
    public void reproduce() {
        print("Making more Hamsters");
    }

    @Override
    public String toString() {
        return "Hamster";
    }
}

public class E14_SharedRodentInitialization {
    public static void main(String[] args) {
        SharedMember sm  =new SharedMember();
        Rodent3[] rodent3s = {
                new Hamster3(sm),
                new Gerbil3(sm),
                new Mouse3(sm)
        };
        for (Rodent3 r : rodent3s) {
            r.dispose();
        }
    }
}
