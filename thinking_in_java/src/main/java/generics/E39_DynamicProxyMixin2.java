package generics;

import java.awt.*;

import static generics.Tuple2.tuple;

/**
 * @author: liuHua
 * @create: 2018-12-19 15:22
 * Add a new mixin class Colored to
 * DynamicProxyMixin.java, mix it in to mixin, and
 * show that it works
 **/

public class E39_DynamicProxyMixin2 {
	public static void main(String[] args) {
		Object mixin = MixinProxy.newInstance(
				tuple(new BasicImp(), Basic.class),
				tuple(new TimeStampedImp(), TimeStamped.class),
				tuple(new SerialNumberedImp(), SerialNumbered.class)
				);
		
		Basic b = (Basic) mixin;
		TimeStamped t = (TimeStamped) mixin;
		SerialNumbered s = (SerialNumbered) mixin;
		b.set("Hello");
		System.out.println(b.get());
		System.out.println(t.getStamp());
		System.out.println(s.getSerialNumber());
	}
}
