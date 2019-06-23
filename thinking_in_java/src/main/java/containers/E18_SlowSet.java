package containers;

import control.Count;
import net.lh.util.Countries;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lh
 * Using SlowMap.java for inspiration, creation a SlowSet
 **/
class SlowSet<K> extends AbstractSet<K> {
    private List<K> keys = new ArrayList<>();

    @Override
    public boolean add(K k) {
        if (!contains(k)) {
            keys.add(k);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return keys.iterator();
    }

    @Override
    public int size() {
        return keys.size();
    }
}
public class E18_SlowSet {
    public static void main(String[] args) {
        SlowSet<String> slowSet = new SlowSet<>();
        slowSet.addAll(Countries.names(10));
        slowSet.addAll(Countries.names(10));
        slowSet.addAll(Countries.names(10));
        System.out.println(slowSet);
    }
}
