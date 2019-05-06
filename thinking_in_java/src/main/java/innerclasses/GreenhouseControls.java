package innerclasses;

import innerclasses.controller.Controller;
import innerclasses.controller.Event;

/**
 * @author lh
 * This produces a specific applicaton of hte
 * control system. all in a single class. Inner
 * classes allow you to encapsulate different
 * functionality for each type of event.
 **/
public class GreenhouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the light:
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }


    public class LightOff extends Event {
        @Override
        public void action() {
            // Put hardware control code here ot
            // physically turn off the light.
            light = false;
        }

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }

        @Override
        public void action() {
            // Put hardware control code here.
            water = true;
        }
    }

    public class WaterOff extends Event {
        @Override
        public String toString() {
            return "Greenhouse water is off";
        }

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here
            water = false;
        }
    }


    private String thermostat = "Day";

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            //Put hardware control code here.
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        @Override
        public String toString() {
            return "Thermostat on day setting";
        }

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put Hardware control code here.
            thermostat = "Day";
        }
    }

    // An example of an action() that insert a
    // new one of itself into the event list:
    public class Bell extends Event {
        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing";
        }

        public Bell(long delayTime) {
            super(delayTime);
        }
    }

    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList) {
                addEvent(e);
            }
        }

        @Override
        public String toString() {
            return "Restarint system";
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start(); // Return each event
                addEvent(e);
            }
            start(); //Return this Event
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
