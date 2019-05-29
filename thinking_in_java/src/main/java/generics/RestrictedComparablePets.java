package generics;

/**
 * @author lh
 **/
class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

class Gecko extends ComparablePet {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
public class RestrictedComparablePets {
}
