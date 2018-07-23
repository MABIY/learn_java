package generics1;

public class RestrictedComparablePets extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

class Genko extends ComparablePet {
    public int comparaTo(ComparablePet arg) {
        return 0;
    }
}
