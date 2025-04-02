package csc223.dj;

public class MaxHeap implements Heap {
    private char[] heap;
    private int size;

    public MaxHeap() {
        heap = new char[100];
        size = 0;
    }

    public void insert(char value) {
        heap[size] = value;
        int current = size;
        while (current > 0 && heap[current] > heap[(current - 1) / 2]) {
            char temp = heap[current];
            heap[current] = heap[(current - 1) / 2];
            heap[(current - 1) / 2] = temp;
            current = (current - 1) / 2;
        }
        size++;
    }

    public void delete() {
        if (size == 0) {
            return;
        }
        heap[0] = heap[size - 1];
        size--;
        int current = 0;
        while (current < size) {
            int left = 2 * current + 1;
            int right = 2 * current + 2;
            int largest = current;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != current) {
                char temp = heap[current];
                heap[current] = heap[largest];
                heap[largest] = temp;
                current = largest;
            } else {
                break;
            }
        }
    }

    public char peek() {
        if (size == 0) {
            return '-';
        }
        return heap[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result = result + heap[i] + " ";
        }
        return result.trim();
    }
}

