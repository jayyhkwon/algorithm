package algorithm;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest {

    @Test
    public void testBestTimeComplexity(){

        int[] input = new int[]{1,2,3,4,5};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        InsertionSort.sort(input);
        assertArrayEquals(input,answer);
    }

    @Test
    public void testUnsortedArray(){

        int[] input = {64,34,25,12,22,11,90};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        InsertionSort.sort(input);
        assertArrayEquals(input,answer);
    }

    @Test
    public void testWorstTimeComplexity(){

        int[] input = {5,4,3,2,1};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        InsertionSort.sort(input);
        assertArrayEquals(input,answer);
    }
}