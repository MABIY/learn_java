package initialization;

/**
 * @author lh
 * Write a method that take a vararg String array. Verify that you can pass
 * enither a comma-separated list of Strings or a String[] into this method
 **/
public class VarargEx19 {
    static void showStrings(String... args) {
        for (String s : args) {
            System.out.println(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        showStrings("one","three","four");
        showStrings(new String[]{"1","2","3","4"});
    }
}
