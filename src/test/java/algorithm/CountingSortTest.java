package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountingSortTest {


    @Test
    public void test(){
        int[] input = new int[]{2,5,3,0,2,3,0,3};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        int[] result = CountingSort.sort(input);
        assertArrayEquals(result,answer);
    }

    @Test
    public void testBigInteger(){
//        int[] input = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE-10, Integer.MAX_VALUE-100};
        int[] input = new int[]{1,1000};
        int[] answer = Arrays.copyOf(input,input.length);
        Arrays.sort(answer);

        int[] result = CountingSort.sort(input);
        assertArrayEquals(result,answer);

    }

}