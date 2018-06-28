package typeinfo1;

public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // This won't compile:
        Class<Toy> up2 = (Class<Toy>) ftClass.getSuperclass();
        //only produces Object:
        Object object = up.newInstance();
    }
}
