package containers;

import innerclasses.TestParcel;

/**
 * @author: liuHua
 * @create: 2019-01-20 15:20
 **/
public abstract  class Test<C> {
	String name;
	
	public Test(String name) {
		this.name = name;
	}
	
	// Override this method for different test.
	// Returns actual number of repetitions of test
	abstract int test(C list, TestParam tp);
}
