package enumerated;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Capabilities of the Enum class
 */
enum Shrubbery{
    GROUND,CRAWLING,HANGING
}
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal());
            print(s.compareTo(Shrubbery.CRAWLING) + " ");
            print(s.equals(Shrubbery.CRAWLING) +" ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("-------------------");
        }
        // Produce an enum value from a string name:
        for (String s : "GROUND CRAWLING HANGING".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            print(shrub);
            shrub.getDeclaringClass();
        }
    }
}
