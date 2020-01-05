package algorithm;

public class BubbleSort {

    public static void sort(int[] src) {
        int size = src.length;
        boolean swapped;
        for (int i = 1; i < size; i++) {
            swapped = false;
            for (int j = size - 1; j >= i; j--) {
                if (compareTo(src[j], src[j - 1]) < 0) {
                    swap(src, j, j - 1);
                    swapped = true;
                }
            }

            // 이미 정렬된 배열인 경우 정렬을 종료한다. O(n)
            if (swapped == false)
                break;
        }
    }

    private static void swap(int[] src, int i, int j) {
        int tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }

    private static int compareTo(int a, int b) {
        if (a > b)
            return 1;
        else if (a == b)
            return 0;
        else return -1;
    }
}
