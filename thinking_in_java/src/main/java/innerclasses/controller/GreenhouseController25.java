package innerclasses.controller;

import innerclasses.GreenhouseControls;

/**
 * @author lh
 * Inherit from GreenhouseControls in GreenhouseControls.java to Event
 * inner classes that turn water mist generators on and off. Write a new
 * version of GreenhouseController.java to use these new Event objects
 **/
public class GreenhouseController25 {
    public static void main(String[] args) {
        args = new String[]{"5000"};
        GreenhouseControls25 gc = new GreenhouseControls25();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterMistOn(650),
                gc.new WaterMistOff(700),
                gc.new ThermostatDay(1400)
        };

        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        }
        gc.run();
    }
}
