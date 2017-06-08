package maps;

import org.jetbrains.annotations.NotNull;

import java.util.*;


public class LinkedHashMap<K, V> implements Map<K, V> {

    private List<List<maps.Entry<K, V>>> entries;
    private int capacity = 1 << 4;
    private int count;
    private maps.Entry<K, V> head;
    private maps.Entry<K, V> tail;

    public LinkedHashMap() {
        entries = new ArrayList<>();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return null;
        }

        int index = key.hashCode() % entries.size();

        if (entries.get(index).size() == 1) {
            return entries.get(index).get(0).getValue();
        } else if (entries.get(index).size() > 1) {
            for (maps.Entry<K, V> entry : entries.get(index)) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            return null;
        }

        int index = key.hashCode() % entries.size();

        if (entries.get(index) == null) {

        }

        if (entries.get(index).size() > 0) {

        }

        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @NotNull
    @Override
    public Set<K> keySet() {
        return null;
    }

    @NotNull
    @Override
    public Collection<V> values() {
        return null;
    }

    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
