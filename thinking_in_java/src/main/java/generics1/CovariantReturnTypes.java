package generics1;

class Base{}
class Derived extends Base{}

interface OrdinaryGetter{
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    // Return type of overrriden method is allowed to vary:
    Derived get();
}
public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
}
