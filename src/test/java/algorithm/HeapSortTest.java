package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    public void test() {
        int[] input = new int[]{5, 13, 2, 25, 7, 17, 20, 8, 4};
        HeapSort.Heap heap = new HeapSort.Heap(input);
        int[] answer = Arrays.copyOf(input, input.length);
        Arrays.sort(answer);

        HeapSort.heapSort(heap);
        assertArrayEquals(heap.getHeap(), answer);
    }
}