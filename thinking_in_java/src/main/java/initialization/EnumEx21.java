package initialization;

/**
 * @author lh
 * Create an enum of hte least-valuable six types of paper currency.Loop through
 * the values() and print each value and its ordinal()
 **/
public class EnumEx21 {
    public enum Bills{
        ONE,FIVE,TEN,TWENTY,FIFTY,HUNADED
    }

    public static void main(String[] args) {
        for (Bills b : Bills.values()) {
            System.out.println(b + ", ordinal " + b.ordinal());
        }
    }
}
