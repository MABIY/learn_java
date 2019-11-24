import java.io.File;
import java.io.FileFilter;

/**
 * @author lh
 **/
public class Test {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(File::canExecute);
        new P().test(P1::isHidden);
    }
}

