package holding;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IDClass{
    private static int counter;
    private int count = counter++;

    @Override
    public String toString() {
        return "IDClass " + count;
    }
}
public class E07_TestList {
    public static void main(String[] args) {
        IDClass[] idc = new IDClass[10];
        for (int i = 0; i < idc.length; i++) {
            idc[i] = new IDClass();
        }
        List<IDClass> lst = new ArrayList<>(
                Arrays.asList(idc)
        );
        System.out.println("lst = " + lst);
        List<IDClass> subSet = lst.subList(lst.size() / 4, lst.size() / 2);
        System.out.println("subSet = " + subSet);
        // lst.removeAll(subSet);
        subSet.clear();
        System.out.println("lst = " + lst);
    }
}
