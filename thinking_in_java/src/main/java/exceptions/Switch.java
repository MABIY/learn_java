package exceptions;

import static net.lh.util.Print.print;

/**
 * @author lh
 **/
public class Switch {
    private boolean state = false;
    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        print(this);
    }
    public void off() {
        state = false;
        print(this);
    }

    @Override
    public String toString() {
        return state ? "on" : "off";
    }
}
