package enumerated;

import java.util.EnumMap;
import java.util.Map;

import static net.lh.util.Print.print;

/**
 * @author lh
 */
interface Command{
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                print("Kitchen firs!");
            }
        });
        em.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                print("Bathroom alert!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            print(e.getKey() +": ");
            e.getValue().action();
        }
        try { // If there's no value for a particular key:
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }
}
