package reusing;

class Poppet{
    private int i;

    public Poppet(int i) {
        this.i = i;
    }
}
public class BlankFinal {
    private final int i = 0; //Initialized final
    private final int j; //Blank final
    private final Poppet p;//Blank final reference
    //Blank finals MUST be initialized in the constructor:

    public BlankFinal() {
        this.j = 1; //Initialize blank final
        this.p = new Poppet(1);//Initialize blank final reference
    }

    public BlankFinal(int j) {
        this.j = j; // Initialize blank final
        p = new Poppet(j);//Initialize blank  final reference
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
