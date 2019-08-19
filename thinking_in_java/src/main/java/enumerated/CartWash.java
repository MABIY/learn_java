package enumerated;

import java.security.PolicySpi;
import java.util.EnumSet;

import static net.lh.util.Print.print;

/**
 * @author lh
 **/
public class CartWash {
    public enum Cycle {
        UNDERBODY{
            @Override
            void action() {
                print("Spraying the underbody");
            }
        },
        WHEELWASH{
            @Override
            void action() {
                print("Washing the wheels");
            }
        },
        PREWASH{
            @Override
            void action() {
                print("Loosening the dirt");
            }
        },
        BASIC{
            @Override
            void action() {
                print("The basic wash");
            }
        },
        HOTWAX{
            @Override
            void action() {
                print("Applying hot wax");
            }
        },
        RINSE{
            @Override
            void action() {
                print("RInsing");
            }
        },
        BLOWDRY {
            @Override
            void action() {
                print("Blowing dry");
            }
        };
        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        for (Cycle cycle : cycles) {
            cycle.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CartWash wash = new CartWash();
        print(wash);
        wash.washCar();
        // Order of addition is unimportant
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY); // Duplicates ignored
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        print(wash);
        wash.washCar();
    }
}
