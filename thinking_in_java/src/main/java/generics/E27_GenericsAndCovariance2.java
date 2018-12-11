package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-11 22:04
 * show that covariance doesn't work with Lists,
 * Using Numbers and Integers, then introduce
 * wildcards
 **/

public class E27_GenericsAndCovariance2 {
	public static void main(String[] args) {
		//Compile Error: incompatible types:
		// List<Number> nlist = new ArrayList<Integer>();
		// Wildcards allow covariance:
		List<? extends Number> nlist = new ArrayList<Integer>();
		//Compile Error: can't add any type of object:
		// nlist.add(new Integer(1));
		// nlist.add(new Float(1.0));
		// nlist.add(new Object());
		nlist.add(null); // Legal but uninteresting
		// We know that it returns at least number
		Number n = nlist.get(0);
	}
	
}
