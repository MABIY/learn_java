package typeinfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: liuHua
 * @create: 2018-11-30 14:29
 * A constructor is a kind of factory method, Modify RegisteredFactories.java
 * so that instead of using explicit factory the class object is stored in the list,
 * and newInstance() is used to created each object.
 **/

class Part2 {
	static List<Class<? extends Part2>> partClasses =
			Arrays.asList(
					FuelFilter2.class,
					AirFilter2.class,
					CabinAirFilter2.class,
					OilFilter2.class,
					FanBelt2.class,
					PowerSteeringBel2.class,
					GeneratorBelt2.class
			);
	private static Random rand = new Random(47);

	public static Part2 createRandom() {
		int n = rand.nextInt(partClasses.size());
		try {
			return partClasses.get(n).newInstance();
		} catch (IllegalAccessException | InstantiationException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}

class Filter2 extends Part2 {
}

class FuelFilter2 extends Filter2 {
}

class AirFilter2 extends Filter2 {
}

class CabinAirFilter2 extends Filter2 {
}

class OilFilter2 extends Filter2 {
}

class Belt2 extends Part2 {
}

class FanBelt2 extends Belt2 {
}

class GeneratorBelt2 extends Belt2 {
}

class PowerSteeringBel2 extends Belt2 {
}

public class E14_RegisteredFactories2 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part2.createRandom());
		}
	}
}
