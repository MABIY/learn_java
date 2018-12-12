package generics;

import org.omg.PortableInterceptor.HOLDING;

/**
 * @author: liuHua
 * @create: 2018-12-12 17:29
 * Remove all the generics from
 * MultipleInterfaceVariants.java and modify the
 * code so that the example compiles
 **/

interface Payable31{}
class Employee31 implements Payable{}
class Hourly extends Employee31 implements Payable{}
public class E31_MultipleInterfaceVariants2 {
	public static void main(String[] args) {
		new Employee31();
		new Hourly();
	}
}
