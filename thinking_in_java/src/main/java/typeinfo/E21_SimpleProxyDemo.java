package typeinfo;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-03 11:04
 * Modify SimpleProxyDemo.java so it measures
 * methods-call times
 **/
interface Interface21 {
	void doSomething();
	
	void somethingElse(String arg);
}

class RealObject21 implements Interface21 {
	@Override
	public void doSomething() {
		print("doSomething");
	}
	
	@Override
	public void somethingElse(String arg) {
		print("somethingElse " + arg);
	}
}

class SimpleProxy21 implements Interface21 {
	private Interface21 proxied;
	
	public SimpleProxy21(Interface21 proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public void doSomething() {
		print("SimpleProxy doSomething");
		long start = System.nanoTime();
		proxied.doSomething();
		long duration = System.nanoTime() - start;
		print("METHOD-CALL TIME: " + duration);
	}
	
	@Override
	public void somethingElse(String arg) {
		print("SImpleProxy somethingElse " + arg);
		long start = System.nanoTime();
		proxied.somethingElse(arg);
		long duration = System.nanoTime() - start;
		print("METHOD-CALL TIME: " + duration);
	}
}

public class E21_SimpleProxyDemo {
	public static void consumer(Interface21 iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
		consumer(new RealObject21());
		consumer(new SimpleProxy21(new RealObject21()));
	}
}
