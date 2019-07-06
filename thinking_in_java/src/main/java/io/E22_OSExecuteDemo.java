package io;

import net.lh.util.OSExecuteException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lh
 * Modify  OSExecute.java so that , instead of
 * printing the standard output stream, it returns
 * the results of executing the program as a List
 * of Strings . Demonstrate the use of this new
 * version of the utility.
 **/
class OSExecute2{
    public static List<String> command(String command) {
        boolean err = false;
        List<String> output = new LinkedList<>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String s;
            while ((s = results.readLine()) != null) {
                output.add(s);
            }
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );
            // Report errors and return nonzero value
            // to calling process if there are problesm
            while ((s = errors.readLine()) != null) {
                System.err.print(s);
                err = true;
            }
        } catch (IOException e) {
            if (!command.startsWith("CMD /C")) {
                return command("CMD /C " + command);
            }
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (err) {
            throw new OSExecuteException("Errors executing " +
                    command);
        }
        return output;
    }
}
public class E22_OSExecuteDemo {

}
