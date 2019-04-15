package initialization;

/**
 * @author lh
 * Write a switch statement for the enum the previous example. For each
 * case,output a description of that particular currency.
 **/
public class Wallet {
    EnumEx21.Bills b;

    public static void main(String[] args) {
        for (EnumEx21.Bills b : EnumEx21.Bills.values()) {
            System.out.println("Worth: ");
            switch (b) {
                case ONE:
                    System.out.println("$1");
                    break;
                case FIVE:
                    System.out.println("$5");
                    break;
                case TEN:
                    System.out.println("$10");
                    break;
                case TWENTY:
                    System.out.println("$20");
                    break;
                case FIFTY:
                    System.out.println("$50");
                    break;
                case HUNADED:
                    System.out.println("$100");
                    break;
                default:
                    break;
            }
        }

    }
}
