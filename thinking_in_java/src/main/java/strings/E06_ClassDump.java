package strings;

import java.util.Locale;

import static java.lang.String.format;

/**
 * @author: liuHua
 * @create: 2018-11-21 11:51
 * Create a class that contains int,long,float
 * and double fields. Create a toString() method
 * for this class that uses String.format(),and
 * demonstrate that your class work correctly
 **/

class DataHolder {
	
	int intField = 1;
	long longField = 2L;
	float floatField = 3.0f;
	double doubleField = 4.0;
	
	@Override
	public String toString() {
		StringBuilder result =
				new StringBuilder("DataHolder: \n");
		result.append(
				format(Locale.US, "initField: %d\n", intField)
		);
		result.append(
				format(Locale.US, "longField: %d\n", longField)
		);
		result.append(
				format(Locale.US, "floatField: %f\n", floatField)
		);
		result.append(
				format(Locale.US, "doubleField: %e\n", doubleField)
		);
		return result.toString();
	}
}
public class E06_ClassDump {
	public static void main(String[] args) {
		System.out.println(new DataHolder());
	}
}
