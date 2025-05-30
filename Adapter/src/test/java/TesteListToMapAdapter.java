import org.example.ListToMapAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TesteListToMapAdapter {
    private List<String> values;
    private ListToMapAdapter<String> adapter;

    @BeforeEach
    void setup() {
        values = new ArrayList<>(List.of("A", "B", "C"));
        adapter = new ListToMapAdapter<>(values);
    }

    @Test
    void testGetAndPut() {
        assertEquals("A", adapter.get(0));
        adapter.put(3, "D");
        assertEquals("D", adapter.get(3));
    }

    @Test
    void testContainsKeyAndValue() {
        assertTrue(adapter.containsKey(1));
        assertFalse(adapter.containsKey(99));
        assertTrue(adapter.containsValue("C"));
        assertFalse(adapter.containsValue("X"));
    }

    @Test
    void testRemoveAndSize() {
        adapter.remove(2);
        assertEquals(2, adapter.size());
        assertFalse(adapter.containsKey(2));
    }

    @Test
    void testClear() {
        adapter.clear();
        assertTrue(adapter.isEmpty());
        assertEquals(0, adapter.size());
    }

    @Test
    void testValues() {
        Collection<String> vals = adapter.values();
        assertEquals(3, vals.size());
        assertTrue(vals.contains("B"));
    }
}