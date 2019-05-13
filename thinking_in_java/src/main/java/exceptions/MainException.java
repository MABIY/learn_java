package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author lh
 **/
public class MainException {
    // Pass all exceptions to the console:
    public static void main(String[] args) throws IOException {
        // Open the file:
        FileInputStream file = new FileInputStream("thinking_in_java/src/main/java/exceptions/MainException.java");
        // Use the file...
        // Close the file:
        file.close();
    }
}
