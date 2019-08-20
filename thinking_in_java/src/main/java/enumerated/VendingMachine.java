package enumerated;

import net.lh.util.Generator;
import net.lh.util.TextFile;

import java.util.EnumMap;
import java.util.Iterator;

import static enumerated.Input.*;
import static enumerated.VendingMachine.State.GIVING_CHANGE;
import static net.lh.util.Print.print;

/**
 * @author lh
 */
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(Input.class);

    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input type : category.values) {
                categories.put(type, category);
            }
        }
    }

    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    static void run(Generator<Input> generator) {
        while (state != State.TERMINAL) {
            state.next(generator.next());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1) {
            gen = new FileInputGenerator(args[0]);
        }
        run(gen);
    }

    enum StateDuration {TRANSIENT} // Tagging enum

    enum State {
        RESTING {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                }
            }
        },
        ADDING_MONEY {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            print("Insufficient money for " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                print("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if (amount > 0) {
                    print("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            void output() {
                print("Halted");
            }
        };
        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }

        void output() {
            print(amount);
        }
    }
}

// For a basic sanity check:
class RandomInputGenerator implements Generator<Input> {
    @Override
    public Input next() {
        return Input.randomSelection();
    }
}

//Create Inputs from a file of ';' -separated strings:
class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;

    public FileInputGenerator(String fileName) {
        input = new TextFile(fileName, ";").iterator();
    }

    @Override
    public Input next() {
        if (!input.hasNext()) {
            return null;
        }
        return Enum.valueOf(Input.class, input.next().trim());
    }
}

