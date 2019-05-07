package innerclasses.controller;

import innerclasses.GreenhouseControls24;

/**
 * @author lh
 * In GreenhouseControls.java, add Event inner classes that turn fans on and off.
 * Configure GreenhouseController.java to use these new Event objects.
 **/
public class GreenhouseController24 {
    public static void main(String[] args) {
        args = new String[]{
                "5000"
        };
        GreenhouseControls24 gc = new GreenhouseControls24();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FanOn(500),
                gc.new LightOff(400),
                gc.new FanOff(500),
                gc.new WaterOn(600),
                gc.new ThermostatNight(1400),
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls24.Terminate(new Integer(args[0])));
        }
        gc.run();
    }
}
