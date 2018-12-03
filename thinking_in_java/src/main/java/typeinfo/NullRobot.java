package typeinfo;

import typeinfo.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-03 13:45
 **/


class NullRobotProxyHandler implements InvocationHandler {
	private String nullName;
	private Robot proxied = new NRobot();
	
	public NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName = type.getSimpleName() + " NullRobot";
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
	
	private class NRobot implements Robot, Null {
		@Override
		public String name() {
			return nullName;
		}
		
		@Override
		public String model() {
			return nullName;
		}
		
		@Override
		public List<Operation> operations() {
			return Collections.emptyList();
		}
	}
	
}

public class NullRobot {
	public static Robot newNullRobot(Class<? extends Robot> type) {
		return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(),
				new Class[]{Null.class, Robot.class},
				new NullRobotProxyHandler(type));
	}
	
	public static void main(String[] args) {
		Robot[] bots = {
				new SnowRemovalRobot("SnowBee"),
				newNullRobot(SnowRemovalRobot.class)
		};
		for (Robot bot : bots) {
			Robot.Test.test(bot);
		}
	}
}
