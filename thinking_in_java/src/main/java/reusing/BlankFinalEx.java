package reusing;

/**
 * @author lh
 * Create a class with a blank final reference ot an object.Perform
 * initialization at the point of definition of the field inside all
 * constructors. Demonstrate the guarantee that the final must be initialized
 * before use, and that it cannot be changed once initialized.
 **/
class Poppet{
    private int i;

    public Poppet(int k) {
        this.i = k;
    }

    @Override
    public String toString() {
        return ("Poppet" + i);
    }
}
public class BlankFinalEx {
    private final Propet p; // Blank final refernece

    // Blank finals MUST be initialized in the constructor:
    public BlankFinalEx() {
        p = new Propet(1);  // Initialize blank final reference
    }

    public BlankFinalEx(int x) {
        p = new Propet(x); // Initialize blank final reference
    }

    public static void main(String[] args) {
        BlankFinalEx b1 = new BlankFinalEx();
        BlankFinalEx b2 = new BlankFinalEx(47);
        // b1.p = new Propet(2); // Errors: cannot assign values
        // b2.p = new Propet(3); // to final variables p
        System.out.println("b1.p: " + b1.p);
        System.out.println("b2.p: " + b2.p);
    }
}
