package strings;

import java.util.Formatter;
import java.util.Locale;

/**
 * @author lh
 * Modify Receipt.java So that the widths are all
 * controlled by a single set of constant values
 * The goal is to allow yo uto easily change a
 * width by changing a single value in one place.
 **/
class Receipt4{
    public static final int ITEM_WIDTH =15;
    public static final int QTY_WIDTH =5;
    public static final int PRICE_WIDTH = 10;
    private static final String TITLE_FRMT =
            "%-" + ITEM_WIDTH + "s %" + QTY_WIDTH + "s %" + PRICE_WIDTH + "s\n";
    private static final String ITEM_FRMT = "%-" + ITEM_WIDTH + "." + ITEM_WIDTH
            + "s %" + QTY_WIDTH + "d %" + PRICE_WIDTH + ".2f\n";
    private static final String TOTAL_FRMT = "%-" + ITEM_WIDTH + "s %" + QTY_WIDTH
            + "s %" + PRICE_WIDTH + ".2f\n";
    private double total = 0;
    Formatter f = new Formatter(System.out, Locale.US);

    public void printTitle() {
        f.format(TITLE_FRMT, "Item", "Qty", "Price");
        f.format(TITLE_FRMT, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format(ITEM_FRMT, name, qty, price);
        total += price;
    }
    public void printTotal() {
        f.format(TOTAL_FRMT, "Tax", "", total * 0.06);
        f.format(TITLE_FRMT, "", "","-----");
        f.format(TOTAL_FRMT, "Total", "", total * 1.06);
    }
}

public class E04_CustomizableReceipt {
    public static void main(String[] args) {
        Receipt4 receipt4 = new Receipt4();
        receipt4.printTitle();
        receipt4.print("Jack's Magic Beans",4,41232132132188321.25);
        receipt4.print("Princess Peas", 3, 5.1);
        receipt4.print("Three Bears Porridge", 1, 14.29);
        receipt4.printTotal();
    }
}
