package reusing;

/**
 * @author lh
 * "Blank" final fields
 **/
class Propet{
    private int i;

    public Propet(int i) {
        this.i = i;
    }
}
public class BlankFinal {
    private final int i = 0; //Initialzizaed final
    private final int j; // Blank final
    private final Propet p; // Blank final reference
    // Blank finals MUST be initialized inf the constructor:


    public BlankFinal() {
        j = 1; // Initialize blnk final
        p = new Propet(1); // Initialize blank final reference
    }

    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Propet(x); // Initialize blank final reference
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
