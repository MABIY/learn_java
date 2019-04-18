package reusing;


import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify Detergent.java so that is uses delegation.
 **/
class Cleanser1{
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }
    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser1 x = new Cleanser1();
        print(x);
    }
}
public class DetergentDelegation {
    private String s = "DetergenetDelegation";
    Cleanser1 c = new Cleanser1();

    public void append(String a) {
        s += a;
    }
    public void dilute() {
        c.dilute();
    }

    public void apply() {
        c.apply();
    }

    // metehod delegated in part to Cleanser c:
    public void scrub() {
        append(" DetergentDelegation.scrub()");
    }

    public void foam() {
        append(" foam()");
    }

    @Override
    public String toString() {
        return s + " " + c;
    }

    public static void main(String[] args) {
        DetergentDelegation x = new DetergentDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser1.main(args);

    }
}
