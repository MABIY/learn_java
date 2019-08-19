package enumerated;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Exec: javap -c LikeClasses
 */
enum LikeClasses{
    WINKEN{
        @Override
        void behavior() {
            print("Behavior1");
        }
    },BLINKEN{
        @Override
        void behavior() {
            print("Behavior2");
        }
    },
    NOD {
        @Override
        void behavior() {
            print("Behavior3");
        }
    };
    abstract void behavior();
}
public class NotClasses {
    //void f1(LikeClasses.WINKEN instance) // Nope
}
