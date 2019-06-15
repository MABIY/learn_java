package containers;

import java.util.*;

/**
 * @author lh
 * Modify CoutingMapData.java to full implement
 * the flyweight by adding a custom EntrySet class
 * like the one in Countries.java
 **/
class CountingMapData extends AbstractMap<Integer, String> {
    private static String[] chars = ("A B C D E F G H I J K L M N O P Q R S T U V W " +
            "X Y Z").split(" ");
    private int size;

    public CountingMapData(int size) {
        this.size = size;
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return entries;
    }

    private class Entry implements Map.Entry<Integer, String> {
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Entry && index == ((Entry) obj).index;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
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
    }

    class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }

        private class Iter implements Iterator<Map.Entry<Integer, String>> {
            private Entry entry = new Entry(-1);

            @Override
            public boolean hasNext() {
                return entry.index < size - 1;
            }

            @Override
            public Map.Entry<Integer, String> next() {
                entry.index++;
                return entry;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

    }

    private Set<Map.Entry<Integer, String>> entries = new EntrySet();

}

public class E05_CountingMapData2 {
    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
