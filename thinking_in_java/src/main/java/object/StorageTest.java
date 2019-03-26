package object;

/**
 * @author lh
 * Write a program that includes and calls the storage() method defined as a
 * code fragment in this chapther.
 */
public class StorageTest {
    public static void main(String[] args) {
        class StoreStuff{

            int storage(String s) {
                return s.length() * 2;
            }
        }
        StoreStuff x = new StoreStuff();
        System.out.println(x.storage("hi"));
    }
}
