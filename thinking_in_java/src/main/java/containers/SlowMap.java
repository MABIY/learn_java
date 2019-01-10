package containers;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: liuHua
 * @create: 2019-01-10 16:27
 **/

public class SlowMap<K,V> extends AbstractMap<K,V> {
	private List<K> keys = new ArrayList<>();
	private List<V> values = new ArrayList<>();
	
	@Override
	public V put(K key, V value) {
		V oldValue = get(key); //The old value or null
		if (!keys.contains(key)) {
		
		}
		//lhtd develope
	}
	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}
}
