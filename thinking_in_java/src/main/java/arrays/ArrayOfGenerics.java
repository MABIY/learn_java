package arrays;

import java.util.ArrayList;
import java.util.*;

/**
 * @author lh
 **/
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[20];
        ls = (List<String>[])la; // "unchecked" warning
        ls[0] = new ArrayList<>();
        // Compile-time checking produces an error:
        // ls[1] = new ArrayList<Integer>();

        // The problem:  List<String> is a subtype of object
        Object[] objects = ls;
        // compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();

        //However , if your needs are strainghtforward it is
        //possible to create an array of generics, albeit
        // with an "unchecked" warning:
        List<BerylliumSphere>[] sphers = (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < sphers.length; i++) {
            sphers[i] = new ArrayList<>();
        }
    }
}
