package arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = la; // "Unchecked"
        ls[0] = new ArrayList<>();
        // compile-time checkeing produces an error
        //ls[1] = new ArrayList<Integer>();
        // the problem: List<String> is a subtype of object
        Object[] objects = ls; //So assignment is ok
        // Compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();

        // However, if you needs are straightforward  it is
        // possible to create an array of generics, albeit
        List<BerylliumSphere>[] spheres = new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<BerylliumSphere>();
        }
    }
}
