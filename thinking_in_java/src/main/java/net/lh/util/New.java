package net.lh.util;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author lh
 * Utilities to simplify generic container creation
 * by using type arugment interence
 **/
public class New {
    public static <K,V> Map<K,V> map() {
        return new HashMap<>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    // Examples:
    public static void main(String[] args) {
        Map<String, List<String>> sls = New.map();
        List<String> ls = New.list();
        LinkedList<String> lls = New.lList();
        Set<String> ss = New.set();
        Queue<String> qs = New.queue();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }
}
