package algorithm;

public class MergeSort {


    public static void merge(int[] array, int[] tmp, int lo, int mid, int hi) {
        System.arraycopy(array, lo, tmp, lo, hi - lo + 1);

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                array[k] = tmp[j++];

            else if (j > hi)
                array[k] = tmp[i++];

            else if (tmp[i] <= tmp[j])
                array[k] = tmp[i++];

            else if (tmp[i] > tmp[j])
                array[k] = tmp[j++];
        }

    }

    public static void mergeSort(int[] array, int[] tmp, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSort(array, tmp, lo, mid);
            mergeSort(array, tmp, mid + 1, hi);
            merge(array, tmp, lo, mid, hi);
        }
    }
}
