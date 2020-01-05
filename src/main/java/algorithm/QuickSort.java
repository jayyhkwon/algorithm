package algorithm;

public class QuickSort {

    public static void quickSort(int[] src, int from, int to){
        if(from < to){
            int mid = partition(src,from,to);
            quickSort(src,from,mid-1);
            quickSort(src,mid+1,to);
        }
    }

    private static int partition(int[] src, int from, int to) {
        int pivot = src[to];
        // from <= k <= i 이면 A[k] <= x 이다
        // i+1 <= k <=j-1이면 A[k] > x 이다
        // k=r 이면 A[k] =x 이다
        int i = from -1;
        for(int j=from; j<to ;j++){
            if(src[j] < pivot){
                i++;
                swap(src,i,j);
            }
        }
        swap(src,++i,to);
        return i;
    }

    private static void swap(int[] src, int i, int j) {
        int tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }

}
