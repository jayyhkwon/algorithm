package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class RadixSortTest {

    private int[] input;
    private int[] output;

    @BeforeEach
    public void setUp(){
        input = new int[]{329,457,657,839,436,720,355};
        output = new int[]{329,355,457,436,657,720,839};
    }

    @Test
    public void test(){
        int[] result = RadixSort.sort(input);
        assertArrayEquals(result,output);
    }

}