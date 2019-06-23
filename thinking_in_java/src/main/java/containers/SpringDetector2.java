package containers;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lh
 **/
public class SpringDetector2 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SpringDetector.detectSpring(Groundhog2.class);
    }
}
