package enumerated;

import java.util.EnumSet;

import static enumerated.AlarmPoints.KITCHEN;
import static enumerated.AlarmPoints.STAIR1;
import static enumerated.AlarmPoints.STAIR2;
import static net.lh.util.Print.print;

/**
 * @author lh
 * Operations on EnumSets
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        print(points);
        points.addAll(EnumSet.of(STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points = EnumSet.complementOf(points);
        print(points);
    }
}
