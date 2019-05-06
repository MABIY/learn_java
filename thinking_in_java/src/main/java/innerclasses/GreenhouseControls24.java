package innerclasses;

import innerclasses.controller.Controller;
import innerclasses.controller.Event;

/**
 * @author lh
 **/
public class GreenhouseControls24 extends Controller {
    private boolean fan = false;

    public class FanOn extends Event {
        public FanOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return "Fan is on";
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the fan.
            fan = true;
        }
    }

    public class FanOff extends Event {
        public FanOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return  "Fan is off";
        }

        @Override
        public void action() {
            // Put hardware control here to
            // physically turn off the fan.
            fan = false;
        }
    }

    private boolean light = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return "Light is on";
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }

    }

    public class LightOff extends Event {
        @Override
        public String toString() {
            return "Light is off";
        }

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control here to
            // physically turn off the light.
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        @Override
        public String toString() {
            return "Greenhouse water is on";
        }

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here
            water = true;
        }
    }

    public class WaterOff extends Event {
        @Override
        public String toString() {
            return "Greenhouse water is on";
        }

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control here to
            // physically turn off the light.
            light = false;
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event {
        @Override
        public String toString() {
            return "Thermostat on night setting";
        }

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control coded here
            thermostat = "Night";
        }
    }

    public class ThermostatDay extends Event {
        @Override
        public String toString() {
            // Put hardware control code here
            return "Day";
        }

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here
            thermostat = "Day";
        }
    }

    // An example of an action() that insert a
    // new one of itself into  the event list:
    public class Bell extends Event {
        @Override
        public String toString() {
            return "Bing!";
        }

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }
    }

    public class Restart extends Event {
        private Event[] eventList;
        @Override
        public String toString() {
            return "Restarting system";
        }

        public Restart(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start(); //Return each event
                addEvent(e);
            }
            start(); // Return this Event
            addEvent(this);
        }
    }

    public static class Terminate extends Event {
        @Override
        public String toString() {
            return "Terminating";
        }

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }
    }
}
