package containers;

import java.util.*;

/**
 * @author lh
 * Unsupported operations in java containers
 **/
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("----" + msg + "----");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        // Copy of the sublist;
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }

        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }

        try {
            c.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }

        try {
            c.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll() : " + e);
        }

        try {
            c.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }

        // The list.set() method modifies the value but
        // doesn't change the size of the data structure:
        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List.set(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" "));
        test("Modifiale Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("unmodifiableLsit()", Collections.unmodifiableList(new ArrayList<>(list)));

    }
}
