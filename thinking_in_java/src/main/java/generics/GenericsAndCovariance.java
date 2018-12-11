package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-11 21:50
 **/

public class GenericsAndCovariance {
	public static void main(String[] args) {
		//Wildcards allow covariance:
		List<? extends Fruit> flist = new ArrayList<>();
		// flist.add(new Apple());
		//  flist.add(new Fruit());
		// flist.add(new Object());
		flist.add(null);// Legal but unineresting
		// We know that is returns at least Fruit:
		Fruit f = flist.get(0);
		System.out.println(f);
	}
}
