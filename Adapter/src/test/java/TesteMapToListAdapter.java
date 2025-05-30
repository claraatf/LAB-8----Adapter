import org.example.MapToListAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TesteMapToListAdapter {
    private MapToListAdapter<String> adapter;

    @BeforeEach
    void setup() {
        adapter = new MapToListAdapter<>();
        adapter.add("X");
        adapter.add("Y");
    }

    @Test
    void testAddAndGet() {
        adapter.add("Z");
        assertEquals("Z", adapter.get(2));
    }

    @Test
    void testContains() {
        assertTrue(adapter.contains("Y"));
        assertFalse(adapter.contains("W"));
    }

    @Test
    void testRemoveByValue() {
        assertTrue(adapter.remove("X"));
        assertEquals(1, adapter.size());
        assertFalse(adapter.contains("X"));
    }

    @Test
    void testClear() {
        adapter.clear();
        assertTrue(adapter.isEmpty());
    }

    @Test
    void testToArray() {
        Object[] arr = adapter.toArray();
        assertArrayEquals(new Object[]{"X", "Y"}, arr);
    }
}