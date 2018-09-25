package polymorphism;

import static access.util.Print.print;

class Shared13{
    private int refcount = 0;
    private static int counter = 0;

    public Shared13() {
        print("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }
    public void dispose() {
        if (--refcount == 0) {
            print("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared13{" +
                "id=" + id +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        if (refcount != 0) {
            print("Error: object is properly cleaned-up!");
        }


    }

    private int id = counter++;
}

class Composing13{
    private Shared shared;
    private static int counter = 0;
    private int id = counter++;

    public Composing13(Shared shared) {
        print("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        print("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing13{" +
                "id=" + id +
                '}';
    }
}
public class E13_VerifiedRefCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared),
                new Composing(shared)
        };

        for (Composing c : composing) {
            c.dispose();
        }
        System.gc();
        //Verify failur:
        new Composing13(new Shared());
        System.gc();
    }
}
