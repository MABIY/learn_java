package innerclasses.controller;

import innerclasses.GreenhouseControls;

/**
 * @author lh
 * In GreenhouseControls.java, add Event inner classes that turn fans on and off.
 * Configure GreenhouseController.java to use these new Event objects.
 **/
public class GreenhouseController24 {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FanOn // lhtd
        };
    }
}
