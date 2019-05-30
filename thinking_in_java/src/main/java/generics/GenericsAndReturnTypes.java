package generics;

/**
 * @author lh
 **/
interface GenericGetter<T extends GenericGetter<T>>{
    T get();
}

class Getter implements GenericGetter<Getter> {
    @Override
    public Getter get() {
        return null;
    }
}
public class GenericsAndReturnTypes {
    void test(Getter g) {
        Getter result = g.get();
        GenericGetter gg = g.get(); // Also the base type:
    }
}
