package maps;

import java.util.Map;

/**
 * Created by cary on 5/30/17.
 */
class Entry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;
    private Entry<K, V> next;
    private Entry<K, V> last;

    void setKey(K key) {
        this.key = key;
    }

    Entry<K, V> getNext() {
        return next;
    }

    void setNext(Entry<K, V> next) {
        this.next = next;
    }

    Entry<K, V> getLast() {
        return last;
    }

    void setLast(Entry<K, V> last) {
        this.last = last;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        return this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry<?, ?> entry = (Entry<?, ?>) o;

        if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
        return value != null ? value.equals(entry.value) : entry.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
