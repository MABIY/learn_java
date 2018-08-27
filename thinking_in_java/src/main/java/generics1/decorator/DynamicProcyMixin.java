package generics1.decorator;

import generics1.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MixinProxy implements InvocationHandler {
    Map<String,Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object,Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {

            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
public class DynamicProcyMixin {
    // lhtd  starting
}

