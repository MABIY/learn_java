package initialization;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class E22_PageCurrencyTypesEnum2 {
    static void describe(PaperCurrencyTypes pct) {
        printnb(pct + " has a portraint of");
        switch (pct) {
            case ONE:print("George Washington");
            break;
            case TWO:print("Thomas Jefferson");
            break;
            case FIVE:
                print("Abraham Lincoln");
            case TEN:
                print("Alexander Hamilton");
                break;
            case TWENTY:
                print("Andrew Jackson");
                break;
            case FIFTY:
                print("U.S. Grant");
                break;
        }
    }

    public static void main(String[] args) {
        for (PaperCurrencyTypes s : PaperCurrencyTypes.values()) {
            describe(s);
        }
    }
}
