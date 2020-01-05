package algorithm;

public class MaxSubArray_v2 {

    public static int getMaxSubArray(int[] src, int lo, int hi){
        if(lo==hi)
            return src[lo];

        // 1. 중간에 걸친 경우
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = (lo+hi)/2;

        for(int i=mid; i>=lo; i--){
            sum += src[i];
            if(sum > leftSum)
                leftSum = sum;
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int j=mid+1; j<=hi; j++){
            sum += src[j];
            if(sum > rightSum)
                rightSum = sum;
        }

        // 2. 중간에 걸치지 않은 경우
        int single = Math.max(getMaxSubArray(src,lo,mid), getMaxSubArray(src,mid+1,hi));

        return Math.max(leftSum+rightSum, single);
    }
}
