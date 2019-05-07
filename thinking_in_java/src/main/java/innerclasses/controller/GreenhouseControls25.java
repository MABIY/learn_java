package innerclasses.controller;

import innerclasses.GreenhouseControls;

/**
 * @author lh
 * Inherit from GreenhouseControls in GreenhouseControls.java to add Event
 * inner classes that turn water mist generators on and off. Write a new
 * version of GreenhouseController.java to use these new Event objects.
 **/
public class GreenhouseControls25 extends GreenhouseControls {
    private boolean waterMist = false;

    public class WaterMistOn extends Event {
        @Override
        public String toString() {
            return "Water mist generator on";
        }

        public WaterMistOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on water mist generator
            waterMist = true;
        }

    }

    public class WaterMistOff extends Event {
        public WaterMistOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return "Water mist generator off";
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn off water mist generator
            waterMist = false;
        }
    }
}
