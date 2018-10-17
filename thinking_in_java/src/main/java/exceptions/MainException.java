package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainException {
    // Pass all exception to the console:
    public static void main(String[] args) throws Exception {
        // Open the file
        FileInputStream file = new FileInputStream("/home/lh/project/learn_java/thinking_in_java/src/main/java/exceptions/MainException.java");
        //Use the file....
        //Close the file:
        file.close();
    }
}
