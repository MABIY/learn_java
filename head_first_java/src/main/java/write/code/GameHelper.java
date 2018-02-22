package write.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameHelper {
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        BufferedReader is = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOExceptiion: " + e);
        }
        return inputLine;
    }
}
