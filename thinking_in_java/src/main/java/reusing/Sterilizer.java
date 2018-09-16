package reusing;

import static org.greggordon.tools.Print.println;

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
        println(x);
        println("Testing base class:");
        Detergent.main(args);
    }
}
