package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArray_v2Test {

    @Test
    public void test(){
        int[] testCase = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int result = MaxSubArray_v2.getMaxSubArray(testCase,0,testCase.length-1);
        assertEquals(result,43);


    }
}