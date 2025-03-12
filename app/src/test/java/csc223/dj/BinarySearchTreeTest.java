package csc223.dj;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    public void setUp() {
        bst = new BinarySearchTree();
    }
    @Test
    public void testInsert() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        String result = bst.inOrder();
        assertEquals("30 50 70", result);
    }
    @Test
    public void testSearchFound() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        boolean found = bst.search(30);
        assertTrue(found);
    }
    @Test
    public void testSearchNotFound() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        boolean found = bst.search(100);
        assertFalse(found);
    }
    @Test
    public void testDeleteLeafNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.delete(70);
        String result = bst.inOrder();
        assertEquals("30 50", result);
    }
    @Test
    public void testDeleteNodeWithOneChild() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(80);
        bst.delete(70);
        String result = bst.inOrder();
        assertEquals("30 50 80", result);
    }
    @Test
    public void testDeleteNodeWithTwoChildren() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.delete(70);
        String result = bst.inOrder();
        assertEquals("30 50 60 80", result);
    }
    @Test
    public void testUpdate() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.update(70, 75);
        String result = bst.inOrder();
        assertEquals("30 50 75", result);
    }
    @Test
    public void testInOrderTraversal() {
        bst.insert(40);
        bst.insert(20);
        bst.insert(60);
        bst.insert(10);
        bst.insert(30);
        bst.insert(50);
        bst.insert(70);
        String result = bst.inOrder();
        assertEquals("10 20 30 40 50 60 70", result);
    }
    @Test
    public void testSortedArrayToBST() {
        int[] arr = {10, 20, 30, 40, 50};
        bst.sortedArrayToBST(arr);
        String result = bst.inOrder();
        assertEquals("10 20 30 40 50", result);
    }
    @Test
    public void testLowestCommonAncestor() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        int lca = bst.lowestCommonAncestor(20, 40);
        assertEquals(30, lca);
    }
}

