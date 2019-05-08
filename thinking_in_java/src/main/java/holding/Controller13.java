package holding;

import innerclasses.controller.Event;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author lh
 * In the innerclases/GreenhouseController.java example, the class
 * controller uses an ArrayList. Change the code to use a LinkedList
 * instead, and use an Iterator to cycle throught the set of events
 **/
public class Controller13 {
    // A class from java.util to hold Event object:
    private LinkedList<Event> eventList = new LinkedList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        LinkedList<Event> eventListCopy = new LinkedList<>(eventList);
        ListIterator<Event> it = eventListCopy.listIterator();
        while (it.hasNext()) {
            it.next().action();
            it.previous();
            System.out.println(it.next());
        }
    }
}
