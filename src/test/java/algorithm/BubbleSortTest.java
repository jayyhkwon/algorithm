package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    @Test
    public void testBestTimeComplexity(){

        int[] input = new int[]{1,2,3,4,5};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        BubbleSort.sort(input);
        assertArrayEquals(input,answer);
    }

    @Test
    public void testUnSortedArray(){

        int[] input = {64,34,25,12,22,11,90};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        BubbleSort.sort(input);
        assertArrayEquals(input,answer);
    }

    @Test
    public void testWorstTimeComplexity(){

        int[] input = {5,4,3,2,1};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        BubbleSort.sort(input);
        assertArrayEquals(input,answer);
    }

}