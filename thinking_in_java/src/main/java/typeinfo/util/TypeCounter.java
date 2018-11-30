package typeinfo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuHua
 * @create: 2018-11-30 13:29
 **/

public class TypeCounter extends HashMap<Class<?>,Integer> {
	private Class<?> basetType;
	
	public TypeCounter(Class<?> basetType) {
		this.basetType = basetType;
	}
	
	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if (!basetType.isAssignableFrom(type)) {
			throw new RuntimeException(obj + " incorrect type: " +
					type + " should be type or subtype of "
					+ basetType);
		}
		countClass(type);
	}
	
	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1);
		Class<?> superClass = type.getSuperclass();
		if (superClass != null &&
				basetType.isAssignableFrom(superClass)) {
			countClass(superClass);
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(". ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("}");
		return result.toString();
	}
}
