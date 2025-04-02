package csc223.dj;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {
    private Heap maxHeap;
    private Heap minHeap;

    @Before
    public void setUp() {
        maxHeap = new MaxHeap();
        minHeap = new MinHeap();
    }

    @Test
    public void testInsertAndPeekMax() {
        maxHeap.insert('B');
        maxHeap.insert('A');
        maxHeap.insert('C');
        assertEquals('C', maxHeap.peek());
    }

    @Test
    public void testInsertAndPeekMin() {
        minHeap.insert('B');
        minHeap.insert('A');
        minHeap.insert('C');
        assertEquals('A', minHeap.peek());
    }

    @Test
    public void testDeleteMax() {
        maxHeap.insert('D');
        maxHeap.insert('B');
        maxHeap.insert('A');
        maxHeap.delete();
        assertNotEquals('D', maxHeap.peek());
    }

    @Test
    public void testDeleteMin() {
        minHeap.insert('D');
        minHeap.insert('B');
        minHeap.insert('A');
        minHeap.delete();
        assertNotEquals('A', minHeap.peek());
    }

    @Test
    public void testSizeAndIsEmpty() {
        assertTrue(maxHeap.isEmpty());
        maxHeap.insert('Z');
        assertEquals(1, maxHeap.size());
    }

    @Test
    public void testClear() {
        minHeap.insert('M');
        minHeap.insert('N');
        minHeap.clear();
        assertTrue(minHeap.isEmpty());
    }

    @Test
    public void testToString() {
        maxHeap.insert('X');
        maxHeap.insert('Y');
        String result = maxHeap.toString();
        assertTrue(result.contains("X") && result.contains("Y"));
    }
}

