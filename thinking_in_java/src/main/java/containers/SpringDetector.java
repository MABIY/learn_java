package containers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-10 15:47
 **/

public class SpringDetector {
	// Use a Groundhog or class derived from Groundhog:
	public static <T extends Groundhog> void detectSpring(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Groundhog, Prediction> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(ghog.newInstance(i), new Prediction());
		}
		print("map = " + map);
		Groundhog gh = ghog.newInstance(3);
		print("Looking up prediction for " + gh);
		if (map.containsKey(gh)) {
			print(map.get(gh));
		} else {
			print("Key not found: " + gh);
		}
	}
	
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		detectSpring(Groundhog.class);
	}
}
