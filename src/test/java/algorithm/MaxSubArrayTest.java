package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {

    @Test
    public void test(){

        int[] testCase = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        MaxSubArray.ArrayInfo arrayInfo = MaxSubArray.findMaximumSubArray(testCase,0,15);
        assertEquals(arrayInfo.getSum(),43);
    }

}