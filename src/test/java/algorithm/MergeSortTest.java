package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    public void test(){

        int[] input = new int[]{5,4,3,3,2,1};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        MergeSort.mergeSort(input,new int[input.length],0,input.length-1);
        assertArrayEquals(input,answer);

    }

}