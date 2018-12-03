package typeinfo;

import typeinfo.util.Null;

/**
 * @author: liuHua
 * @create: 2018-12-03 13:10
 **/
public class Person {
	public final String first;
	public final String last;
	public final String address;
	
	// etc
	
	public Person(String first, String last, String address) {
		this.first = first;
		this.last = last;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person{" +
				"first='" + first + '\'' +
				", last='" + last + '\'' +
				", address='" + address + '\'' +
				'}';
	}
	
	public static class NullPerson extends Person implements Null {
		public NullPerson() {
			super("None","None","None");
		}
	}
	
	public static final Person NULL = new NullPerson();
}
