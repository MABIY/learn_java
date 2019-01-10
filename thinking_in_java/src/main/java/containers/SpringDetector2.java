package containers;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: liuHua
 * @create: 2019-01-10 16:00
 **/

public class SpringDetector2 {
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		SpringDetector.detectSpring(Groundhog2.class);
	}
}
