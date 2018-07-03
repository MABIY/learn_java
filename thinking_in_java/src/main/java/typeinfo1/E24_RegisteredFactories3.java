package typeinfo1;

import typeinfo1.factory.Factory;
import typeinfo1.pets2.EgyptianMau;
import typeinfo1.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface IPart {
}

class NullPartProxyHandler implements InvocationHandler {
    private String nullName;
    private IPart proxied = new NPart();

    NullPartProxyHandler(Class<? extends IPart> type) {
        nullName = type.getSimpleName() + ": [Null Part]";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }

    private class NPart implements Null, IPart {
        @Override
        public String toString() {
            return nullName;
        }
    }
}

class Part3 implements IPart {
    public static IPart newNull(Class<? extends IPart> type) {
        return (IPart) Proxy.newProxyInstance(
                IPart.class.getClassLoader(),
                new Class<?>[]{Null.class, IPart.class},
                new NullPartProxyHandler(type));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<IPart>> partFactories = new ArrayList<>();

    static {
        partFactories.add(new FuelFilter3.Factory());
        partFactories.add(new AirFilter3.Factory());
        partFactories.add(new CabinAirFilter3.Factory());
        partFactories.add(new OilFilter3.Factory());
        partFactories.add(new PowerSteeringBelt3.Factory());
        partFactories.add(new GeneratorBelt3.Factory());
    }

    private static Random rand = new Random(47);

    public static IPart createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

}

class Filter3 extends Part3 {}

class FuelFilter3 extends Filter3 {
    public static class Factory implements typeinfo1.factory.Factory<IPart> {
        @Override
        public IPart create() {
            return new FuelFilter3();
        }
    }
}

class AirFilter3 extends Filter3 {
    public static class Factory implements typeinfo1.factory.Factory<IPart> {
        @Override
        public IPart create() {
            return new AirFilter3();
        }
    }
}

class CabinAirFilter3 extends Filter3{
    public static class Factory implements typeinfo1.factory.Factory<IPart> {
        @Override
        public IPart create() {
            return new CabinAirFilter3();
        }
    }
}

class OilFilter3 extends Filter3 {
    public static class Factory implements typeinfo1.factory.Factory<IPart> {
        @Override
        public IPart create() {
            return new OilFilter3();
        }
    }
}

class Belt3 extends Part3{

}

class FanBelt3 extends Belt3{
    public static class Factory implements typeinfo1.factory.Factory<IPart> {
        @Override
        public IPart create() {
            return new FanBelt3();
        }
    }

}

class GeneratorBelt3 extends Belt3 {
    public static class Factory implements typeinfo1.factory.Factory<IPart> {
        @Override
        public IPart create() {
            return new GeneratorBelt3();
        }
    }
}

class PowerSteeringBelt3 extends Belt3 {
    public static class Factory implements typeinfo1.factory.Factory<IPart> {
        @Override
        public IPart create() {
            return new PowerSteeringBelt3();
        }
    }
}
public class E24_RegisteredFactories3 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            IPart part = Part3.createRandom();
            //Real object
            System.out.println(part);
            // Null companion
            System.out.println(Part3.newNull(part.getClass()));
        }
    }
}
