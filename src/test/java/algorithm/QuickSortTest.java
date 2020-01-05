package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    public void test(){

        int[] input = new int[]{13,19,9,5,12,8,7,4,21,2,11};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        QuickSort.quickSort(input,0,input.length-1);
        assertArrayEquals(input,answer);
    }
}