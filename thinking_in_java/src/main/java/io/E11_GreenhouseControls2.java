package io;

import innerclasses.GreenhouseControls;
import innerclasses.controller.Event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.LinkedList;

/**
 * @author lh
 * {Args: 5000000}
 * (Intermediate) In the
 * innerclasses/GreenhouseController.java example
 * GreenhouseController contains a hard-code set of events.
 * Change the program so that it reads the event and their
 * relative times from a text file.(Challenging: Use a
 * Factory Method design pattern to build the events-see
 * Thinking in Patterns (with Java) at www.MindView.net.)
 **/

class GreenhouseControls2 extends GreenhouseControls {

    class Restart extends Event{
        private Event[] eventList;
        public Restart(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            for (Event event : eventList) {
                event.start(); // Rerun each event
                addEvent(event);
            }
        }

        @Override
        public String toString() {
            return "Restarting system";
        }

        public void setEventList(Event[] eventList) {
            this.eventList = eventList;
        }
    }
}

class GHEventFactory{
    LinkedList<EventCreator> events = new LinkedList<>();
    class EventCreator{
        Constructor<Event> ctor;
        long offset;

        public EventCreator(Constructor<Event> ctor, long offset) {
            this.ctor = ctor;
            this.offset = offset;
        }
    }

    public GHEventFactory(String eventFile) {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(eventFile)
            );
            String s;
            while ((s = in.readLine()) != null) {
                int colon = s.indexOf(":");
                // Must use '$' instead of '.' to
                // describe inner clases
                String className = s.substring(0, colon).trim();
                Class<?> outer = className.equals("Restart") ?
                        GreenhouseControls2.class : GreenhouseControls.class;
                String type = outer.getSimpleName() + "$" + className;
                long offset = Long.parseLong(s.substring(colon + 1).trim());
                // Use Reflection to find and call
                // the right constructor:
                Class<Event> eventClass = (Class<Event>) Class.forName(type);
                // Inner class construcotrs implicitly
                // take the outer-class object  as a
                // first argument
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
public class E11_GreenhouseControls2 {
}
