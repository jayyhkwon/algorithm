package algorithm;

public class MaxSubArray {

    public static ArrayInfo findMaxCrossingSubArray(int[] src, int lo, int mid, int hi){
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        ArrayInfo answer = new ArrayInfo();

        for(int i=mid; i>lo; i--){
            sum += src[i];
            if(sum > left_sum){
                left_sum = sum;
                answer.leftIndex = i;
            }
        }
        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        for(int j=mid+1; j<hi; j++){
            sum += src[j];
            if(sum > right_sum){
                right_sum = sum;
                answer.rightIndex = j;
            }
        }

        answer.setSum(left_sum + right_sum);

        return answer;
    }

    public static ArrayInfo findMaximumSubArray(int[] src, int lo, int hi){
        ArrayInfo answer = new ArrayInfo();
        if(lo==hi){
            answer.setSum(src[lo]);
            return answer;
        }
        int mid = (lo+hi)/2;
        ArrayInfo leftArrayInfo = findMaximumSubArray(src,lo,mid);
        ArrayInfo rightArrayInfo = findMaximumSubArray(src,mid+1,hi);
        ArrayInfo crossArrayInfo = findMaxCrossingSubArray(src,lo,mid,hi);


        if(leftArrayInfo.getSum() >= rightArrayInfo.getSum() && leftArrayInfo.getSum() >= crossArrayInfo.getSum())
            return leftArrayInfo;
        else if (rightArrayInfo.getSum() >= leftArrayInfo.getSum() && rightArrayInfo.getSum() >= crossArrayInfo.getSum())
            return rightArrayInfo;
        else
            return crossArrayInfo;
    }

    public static class ArrayInfo{

        private int leftIndex;
        private int rightIndex;
        private int sum;

        public int getLeftIndex() {
            return leftIndex;
        }

        public void setLeftIndex(int leftIndex) {
            this.leftIndex = leftIndex;
        }

        public int getRightIndex() {
            return rightIndex;
        }

        public void setRightIndex(int rightIndex) {
            this.rightIndex = rightIndex;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }
}
