package interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @author lh
 * Create a class that produces a sequence of chars. Adapt this class to
 * that it can be an input ot a Scanner object.
 **/
public class AdaptedRandomChars16 extends RandomChars implements Readable{
    private int count;
    public AdaptedRandomChars16(int count){
        this.count =count;
    }
    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        String result = Character.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomChars16(128));
        while(s.hasNext()){
            System.out.println(s.next() +" ");
        }
    }
}
