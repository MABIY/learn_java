package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-28 20:22
 **/

class StringAddress{
	private String s;
	
	public StringAddress(String s) {
		this.s = s;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + s;
	}
}
public class FillingLists {
	public static void main(String[] args) {
		List<StringAddress> list = new ArrayList<StringAddress>(
				Collections.nCopies(4, new StringAddress("Hello"))
		);
		System.out.println(list);
		Collections.fill(list, new StringAddress("Word!"));
		System.out.println(list);
	}
}
