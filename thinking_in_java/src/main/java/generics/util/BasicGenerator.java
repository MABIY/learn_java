package generics.util;

/**
 * @author: liuHua
 * @create: 2018-12-05 15:30
 * Automatically create a Generator. given a class
 * with a default (no-arg) constructor
 **/

public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;
	
	@Override
	public T next() {
		// Assumes type have  public constructor
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public BasicGenerator(Class<T> type) {
		this.type = type;
	}
	
	// Produce a Default generator given a type token:
	
	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<>(type);
	}
}
