package reusing;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Inherit a new class from class Detergent, Override scrub() and a new method
 * called sterilize()
 **/
public class Sterilizer extends Detergent{
    @Override
    public void scrub() {
        append(" Sterilizer.scrub()");
    }

    public void sterilize() {
        append(" sterilize()");
    }

    public static void main(String[] args) {
        Sterilizer x = new Sterilizer();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.sterilize();
        print(x);
        print("Testing base class:");
        Detergent.main(args);
    }
}
