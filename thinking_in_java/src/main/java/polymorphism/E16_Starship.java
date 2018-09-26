package polymorphism;

class AlertStatus{
    public String getStatus() {
        return "None";
    }
}

class RedAlertStatus extends AlertStatus{
    @Override
    public String getStatus() {
        return "Red";
    }
}

class YellowAlertStatus extends AlertStatus {
    @Override
    public String getStatus() {
        return "Yellow";
    }
}

class GreenAlertStatus extends AlertStatus {
    @Override
    public String getStatus() {
        return "Green";
    }
}

class StarShip{
    private AlertStatus status = new GreenAlertStatus();

    public void setStatus(AlertStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status.getStatus();
    }
}

public class E16_Starship {
    public static void main(String[] args) {
        StarShip eprise = new StarShip();
        System.out.println(eprise);
        eprise.setStatus(new YellowAlertStatus());
        System.out.println(eprise);
        eprise.setStatus(new RedAlertStatus());
        System.out.println(eprise);
    }
}
