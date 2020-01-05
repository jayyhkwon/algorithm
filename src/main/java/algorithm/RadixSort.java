package algorithm;

public class RadixSort {

    public static int[] sort(int[] src){
        int[] output = new int[src.length];
        int max = getMax(src);

        // 1의 자리, 10의 자리 ... 별로 계수정렬한다.
        for(int exp=1; max/exp>0; exp*=10){
            output = countSort(src, exp);
        }
        return output;
    }

    private static int getMax(int[] src) {
        int max = src[0];

        for(int i=0; i<src.length; i++){
            if(src[i] > max)
                max = src[i];
        }
        return max;
    }

    public static int[] countSort(int[] src, int exp){
        int[] output = new int[src.length];
        int[] count = new int[10]; // 0~9 count를 위한 배열

        for(int i=0; i<src.length; i++){
            count[(src[i]/exp)%10]++;
        }

        for(int i=1; i<10; i++) {
            count[i] += count[i-1];
        }

        for(int i=src.length-1; i>=0; i--){
            output[count[(src[i]/exp)%10]-1]=src[i];
            count[(src[i]/exp)%10]--;
        }
        return output;
    }
}
