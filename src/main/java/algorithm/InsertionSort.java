package algorithm;

public class InsertionSort {

    public static void sort(int[] src) {
        for (int i = 1; i < src.length; i++) {
            int key = src[i];
            int j = i - 1;
            while (j >= 0 && src[j] > key) {
                src[j + 1] = src[j];
                j--;
            }
            src[j + 1] = key;
        }
    }
}
