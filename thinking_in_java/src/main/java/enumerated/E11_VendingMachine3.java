package enumerated;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import net.lh.util.Enums;
import net.lh.util.Generator;
import net.lh.util.TextFile;

import java.util.*;

import static net.lh.util.Print.print;

enum Input2 {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    VENDED_ITEM, ABORT_TRANSACTION {
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amont()");
        }
    },
    STOP { // This must be the last instance.

        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    static Random rand = new Random(47);
    int value; // In cents

    Input2(int value) {
        this.value = value;
    }

    Input2() {
    }

    public static Input2 randomSelection() {
        // Don't include STOP:
        return values()[rand.nextInt(values().length) - 1];
    }

    int amount() {
        return value; // In cents
    }
}

enum Category2 {
    MONEY(Input2.NICKEL, Input2.DIME, Input2.QUARTER, Input2.DOLLAR),
    ITEM_SELECTION(Input2.VENDED_ITEM),
    QUIT_TRANSACTION(Input2.ABORT_TRANSACTION),
    SHUT_DOWN(Input2.STOP);
    private static EnumMap<Input2, Category2> categories = new EnumMap<Input2, Category2>(Input2.class);

    static {
        for (Category2 c : Category2.class.getEnumConstants()) {
            for (Input2 type : c.values) {
                categories.put(type, c);
            }
        }
    }

    private Input2[] values;

    Category2(Input2... types) {
        values = types;
    }

    public static Category2 categorize(Input2 input) {
        return categories.get(input);
    }

}

/**
 * @author lh
 * {Args: VendedItems.txt VendingMachineInput.txt}
 * ******************************
 * IN a real vending machine you will want to easily
 * ******************************
 */

// A simple data holder class
class VendedItem {
    private static List<VendedItem> items = new ArrayList<>();
    private static Random rand = new Random(47);
    int amount;
    String name;

    public VendedItem(String name, int amount) {
        this.amount = amount;
        this.name = name;
    }

    // The data is expected to be in a format: <name><amount>
    public static VendedItem parse(String data) {
        String[] s = data.split(" ");
        return new VendedItem(s[0], Integer.parseInt(s[1]));
    }

    public static void addItem(VendedItem item) {
        items.add(item);
    }

    // A very slow lookup procedure
    public static VendedItem lookup(String name) {
        for (VendedItem item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    public static VendedItem randomSelection() {
        return items.get(rand.nextInt(items.size()));
    }
}

// A class representing an input to a state maching
class ExtInput {
    Input2 input;
    VendedItem item;

    public ExtInput(Input2 input, VendedItem item) {
        this.input = input;
        this.item = item;
    }

    public int amount() {
        return item != null ? item.amount : input.amount();
    }

    @Override
    public String toString() {
        return item != null ? item.name : input.toString();
    }
}

public class E11_VendingMachine3 {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static ExtInput selection = null;
    enum StateDuration{TRANSIENT} // Tagging enum
    public enum State {
        RESTING {
            void next(ExtInput input) {
                switch (Category2.categorize(input.input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                }
            }
        },
        ADDING_MONEY{

        },
        DISPENSING(StateDuration.TRANSIENT){

        },
        GIVING_CHANGE(StateDuration.TRANSIENT){

        },
        TERMINAL{
            void output() {
                print("Halted");
            }
        };
        private boolean isTransient = false;
        State(){}

        State(StateDuration tran) {
            isTransient = true;
        }

        void next(ExtInput input) {
            throw new RuntimeException("Only call " +
                    "next(ExtInput input)  for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }

        void output() {
            print(amount);
        }
    }

    static void run(Generator<ExtInput> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("" +
                    "The vended items data file is not given!");
            return;
        }
        Generator<ExtInput> gen;
        if (args.length == 2) {
            gen = new FileExtInputGenerator(args[1]);
        } else {
            gen = new RandomExtInputGenerator();
        }
        //Parse the vended items data file
        for (String data : new TextFile(args[0], ";")) {
            VendedItem.addItem(VendedItem.parse(data.trim()));
        }
        run(gen );

    }
}

//For a basic sanity check:
class RandomExtInputGenerator implements Generator<ExtInput> {
    @Override
    public ExtInput next() {
        return new ExtInput(Input2.randomSelection(), VendedItem.randomSelection());
    }
}

//Create Input2 from a file of ':' -separated strings:
class FileExtInputGenerator implements Generator<ExtInput> {
    private Iterator<String> input;

    public FileExtInputGenerator(String fileName) {
        this.input = new TextFile(fileName, ";").iterator();
    }

    @Override
    public ExtInput next() {
        if (!input.hasNext()) {
            return null;
        }
        String s = input.next().trim();
        try {
            return new ExtInput(Enum.valueOf(Input2.class, s), null);
        } catch (IllegalArgumentException e) {
            // B plan: probably a vended item...
            VendedItem item = VendedItem.lookup(s);
            if (item != null) {
                return new ExtInput(Input2.VENDED_ITEM, item);
            }
            throw e; // Rethrow the catched exception
        }
    }
}
