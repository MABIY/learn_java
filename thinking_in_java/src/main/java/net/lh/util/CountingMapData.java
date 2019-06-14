package net.lh.util;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lh
 **/
public class CountingMapData extends AbstractMap<Integer, String> {
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V X Y Z".split(" ");
    private int size;

    public CountingMapData(int size) {
        if (size < 0) {
            this.size = 0;
        } else {
            this.size = size;
        }
    }


    private static class Entry implements Map.Entry<Integer, String> {
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            return Integer.valueOf(index).equals(obj);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + index / chars.length;
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    @Override
    public Set<Map.Entry<Integer,String>> entrySet() {
        // LinkedHashSet retains initialization order:
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));

    }

}
