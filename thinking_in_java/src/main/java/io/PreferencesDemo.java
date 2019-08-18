package io;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static net.lh.util.Print.print;

/**
 * @author lh
 **/
public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "0z");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?",true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys()) {
            print(key + ": " + prefs.get(key, null));
        }
        // You must always provide a default values:
        print("How many companions dose Dorothy have? "
                + prefs.getInt("Companions", 0));

    }
}
