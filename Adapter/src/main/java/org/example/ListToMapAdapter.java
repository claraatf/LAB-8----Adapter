package org.example;

import java.util.*;

public class ListToMapAdapter<V> implements CustomMap<Integer, V> {
    private final List<V> list;

    public ListToMapAdapter(List<V> list) {
        if (list == null) throw new IllegalArgumentException("List cannot be null.");
        this.list = list;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        if (!(key instanceof Integer)) return false;
        int index = (Integer) key;
        return index >= 0 && index < list.size();
    }

    @Override
    public boolean containsValue(Object value) {
        return list.contains(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListToMapAdapter<?> that)) return false;
        return Objects.equals(list, that.list);
    }

    @Override
    public V get(Object key) {
        if (!(key instanceof Integer)) throw new IllegalArgumentException("Key must be Integer.");
        int index = (Integer) key;
        if (index < 0 || index >= list.size()) throw new IndexOutOfBoundsException("Invalid index: " + index);
        return list.get(index);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public V put(Integer key, V value) {
        if (key == null || key < 0) throw new IllegalArgumentException("Invalid key.");
        while (key >= list.size()) list.add(null);
        return list.set(key, value);
    }

    @Override
    public V remove(Object key) {
        if (!(key instanceof Integer)) throw new IllegalArgumentException("Key must be Integer.");
        int index = (Integer) key;
        if (index < 0 || index >= list.size()) throw new IndexOutOfBoundsException("Invalid index.");
        return list.remove(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Collection<V> values() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
