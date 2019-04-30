package polymorphism;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Following the example in Transmogrify.java,create a Starship class
 * containing an alertStatus reference that can indicate three different states.
 * Include methods to change the states
 **/
class AlertStatus {
    public void alert() {}
}

class NormalAlert extends AlertStatus {
    @Override
    public void alert() {
        print("AlertStatus Normal");
    }
}

class HighAlert extends AlertStatus {
    @Override
    public void alert() {
        print("AlertStatus High");
    }
}

class MaximumAlert extends AlertStatus {
    @Override
    public void alert() {
        print("ALertStatus Maximum");
    }
}

class Starship{
    private AlertStatus alertStatus = new NormalAlert();
    public void normalAlert(){
        alertStatus = new NormalAlert();
    }

    public void highAlert() {
        alertStatus = new HighAlert();
    }

    public void maximumAlert() {
        alertStatus = new MaximumAlert();
    }

    public void checkAlertStatus() {
        alertStatus.alert();
    }
}
public class Transmogrify16 {
    public static void main(String[] args) {
        Starship ss = new Starship();
        ss.checkAlertStatus();
        ss.highAlert();
        ss.checkAlertStatus();
        ss.maximumAlert();
        ss.checkAlertStatus();
        ss.normalAlert();
        ss.checkAlertStatus();

    }
}
