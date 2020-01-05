package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BucketSortTest {

    @Test
    public void test(){

        double[] input = new double[]{0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
        double[] answer = Arrays.copyOf(input, input.length);
        Arrays.sort(answer);

        double[] result = BucketSort.sort(input);
        assertArrayEquals(result,answer);
    }

    @Test
    public void testA(){
        double[] input = new double[]{0.68,0.17,0.39,0.26,0.22,0.94,0.21,0.12,0.23,0.88,0.55,0.77,0.21};
        double[] answer = Arrays.copyOf(input, input.length);
        Arrays.sort(answer);

        double[] result = BucketSort.sort(input);
        assertArrayEquals(result,answer);

    }

}