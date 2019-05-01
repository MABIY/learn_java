package interfaces.interfaceProcessor;

import static net.mindview.util.Print.print;

/**
 * @author lh
 **/
public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
}
