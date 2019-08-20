package enumerated;

import net.lh.util.Enums;

import java.util.Iterator;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify PostOffice.java so it has the ability to forward mail
 */

class FMail {
    static long counter;
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    ForwardAddress forwardAddress;
    long id = counter++;

    // Generate test FMail:
    public static FMail randomMail() {
        FMail m = new FMail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        m.forwardAddress = Enums.random(ForwardAddress.class);
        return m;
    }

    public static Iterable<FMail> generator(final int count) {
        return new Iterable<FMail>() {
            int n = count;

            @Override
            public Iterator<FMail> iterator() {
                return new Iterator<FMail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public FMail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scanability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress +
                ", Forward address: " + forwardAddress;
    }

    // The NO's lower the probability of random selection:
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    enum ForwardAddress {MISSING, OK1, OK2, OK3, OK4, OK5}
}

public class E08_MailForwording {
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handler(FMail m) {
                switch (m.generalDelivery) {
                    case YES:
                        print("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handler(FMail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handler(FMail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("deliverying " + m + " normally");
                                return true;
                        }
                }
            }
        },
        FORWARD_MAIL {
            @Override
            boolean handler(FMail m) {
                switch (m.forwardAddress) {
                    case MISSING:
                        return false;
                    default:
                        print("Returning " + m + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handler(FMail m);
    }

    static void handle(FMail m) {
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handler(m)) {
                return;
            }
        }
        print(m + " is a dead letter");
    }

    public static void main(String[] args) {
        for (FMail mail : FMail.generator(10)) {
            print(mail.details());
            handle(mail);
            print("*****");
        }
    }
}
