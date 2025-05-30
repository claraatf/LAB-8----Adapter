package org.example;

import java.util.*;

public class MapToListAdapter<V> implements CustomList<V> {
    private final Map<Integer, V> map = new LinkedHashMap<>();

    @Override
    public boolean add(V value) {
        if (value == null) throw new IllegalArgumentException("Value cannot be null");
        map.put(map.size(), value);
        return true;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object value) {
        return map.containsValue(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapToListAdapter<?> that)) return false;
        return map.equals(that.map);
    }

    @Override
    public V get(int index) {
        if (index < 0 || index >= map.size()) throw new IndexOutOfBoundsException("Invalid index");
        return map.get(index);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<V> iterator() {
        return map.values().iterator();
    }

    @Override
    public boolean remove(Object value) {
        Integer targetKey = null;
        for (Map.Entry<Integer, V> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                targetKey = entry.getKey();
                break;
            }
        }
        if (targetKey == null) throw new NoSuchElementException("Value not found.");
        map.remove(targetKey);
        return true;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object[] toArray() {
        return map.values().toArray();
    }

    @Override
    public String toString() {
        return map.values().toString();
    }
}
