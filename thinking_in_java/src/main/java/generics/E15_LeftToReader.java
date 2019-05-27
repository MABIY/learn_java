package generics;

import net.lh.util.FiveTuple;
import net.lh.util.FourTuple;
import net.lh.util.ThreeTuple;
import net.lh.util.TwoTuple;

import static net.lh.util.Tuple.tuple;

/**
 * @author lh
 * "Notice that f() returns a parameterized
 * TwoTuple object, while f2() returns an
 * unparameterized TwoTuple object. The compiler
 * doesn't warn about f2() in this case because the
 * return value is not being used in a parameterized
 * fashion; in a sense, it is being "upcast" to an
 * unparamterized TwoTuple. However, if you were to
 * try to capture the result of f2() into a
 * parameterized TwoTuple, the compiler would issue a waring."
 * <p>
 * Verify the previous statement.
 **/
public class E15_LeftToReader {
    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        TwoTuple<String, Integer> ttsi2 = f2();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
