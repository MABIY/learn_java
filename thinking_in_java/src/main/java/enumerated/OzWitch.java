package enumerated;

import static net.lh.util.Print.print;

/**
 * @author lh
 * The witches in the land of Oz
 */
public enum  OzWitch {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch,aka the Wicked Witch of the "),
    NORTH("Glinda, the Goods Witch of the North"),
    EAST("Wicked witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy's house"),
    SOUTH("Goods by interface, but missing");
    private String description;
    // Constructor must be package or private access:

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            print(witch + ": " + witch.getDescription());
        }
    }
}
