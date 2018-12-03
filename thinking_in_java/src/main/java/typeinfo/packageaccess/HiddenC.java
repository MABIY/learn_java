package typeinfo.packageaccess;

import org.omg.CORBA.PRIVATE_MEMBER;
import typeinfo.A;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-03 14:41
 **/

class C implements A {
	@Override
	public void f() {
		print("public C.f()");
	}
	
	public void g() {
		print("public C.g()");
	}
	
	void u() {
		print("package C.u()");
	}
	
	protected void v() {
		print("protected C.v()");
	}
	
	private void w() {
		print("private C.w()");
	}
}
public class HiddenC {
	public static A makeA() {
		return new C();
	}
}
