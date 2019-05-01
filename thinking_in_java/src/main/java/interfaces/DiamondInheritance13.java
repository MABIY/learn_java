package interfaces;

/**
 * @author lh
 * Create an interface, and inherit two new interfaces from that
 * interface. Multiply inherit a third interface from the second two.
 **/
interface CanDo{
    void doIt();
}

interface CanDoMore extends CanDo {
    void doMor();
}

interface CanDoFaster extends CanDo {
    void doFaster();
}

interface CanDoMost extends CanDoMore, CanDoFaster {
    void doMost();
}

class Doer implements CanDoMost {
    @Override
    public void doIt() {

    }

    @Override
    public void doMor() {

    }

    @Override
    public void doFaster() {

    }

    @Override
    public void doMost() {

    }
}
public class DiamondInheritance13 {
    public static void main(String[] args) {
        Doer d = new Doer();
        ((CanDoMore)d).doMor();
        ((CanDoFaster) d).doFaster();
        ((CanDo)d).doIt();
    }
}
