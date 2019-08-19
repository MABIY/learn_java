package enumerated;

import com.sun.org.apache.regexp.internal.RE;

import static enumerated.Signal.*;
import static net.mindview.util.Print.print;

/**
 * @author lh
 * ******************************
 * Use a static import to modify TrafficLight.java
 * so you don't have to qualify the enum instances.
 * ******************************
 */
public class E01_TrafficLight2 {
    Signal color = RED;
    public void change() {
        switch (color) {
            case RED: color =GREEN;
            break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        E01_TrafficLight2 t = new E01_TrafficLight2();
        for (int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }
}
