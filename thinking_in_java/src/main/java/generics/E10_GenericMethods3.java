package generics;

import operators.Bool;
import typeinfo.E10_PrimitiveOrTrue;

/**
 * @author: liuHua
 * @create: 2018-12-05 13:25
 * Modify the previous exercise sot that
 * one of f()'s arguments is non-parameterized
 **/

public class E10_GenericMethods3 {
	public <A, B> void f(A a, Boolean c, B b) {
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
		System.out.println(c.getClass().getName());
	}
	
	public static void main(String[] args) {
		E10_GenericMethods3 gm = new E10_GenericMethods3();
		gm.f("",true,1);
		gm.f(1.0,false,1.0F);
		gm.f('c',true,gm);
	}
}
