package algorithm;

import java.util.*;

/**
 * 0<= x <= 1 사이의 범위에서 원소를 균일하게 분포시키도록 하는 무작위 과정을 통해 입력이 균일하고 독립적으로 만들어졌다고 가정한다.
 */

public class BucketSort {

    public static double[] sort(double[] src) {
        double[] result = new double[src.length];
        int resultIdx = 0; // 버킷 별로 정렬된 원소를 result 배열에 넣을 때 필요한 idx

        // [List<Double>,List<Double>,List<Double>...] 배열을 만든다(버킷)
        List<Double>[] buckets = new ArrayList[10];

        for (int i = 0; i < src.length; i++) {
            int idx = (int) ((src[i] * 10) % 10);
            if (buckets[idx] == null) {
                buckets[idx] = new ArrayList<>();
            }
            buckets[idx].add(src[i]);
        }

        for (int i = 0; i < buckets.length; i++) {
            // 버킷별로 삽입정렬로 정렬한다
            InsertionSort(buckets[i]);
            List<Double> sorted = buckets[i];

            if (sorted == null)
                continue;
            // 버킷별로 정렬한 원소를 result 배열에 담는다
            for (int j = 0; j < sorted.size(); j++) {
                result[resultIdx++] = sorted.get(j);
            }
        }

        return result;
    }

    private static void InsertionSort(List<Double> src) {
        if (src == null)
            return;

        for (int i = 1; i < src.size(); i++) {
            double key = src.get(i);
            int j = i - 1;
            while (j >= 0 && src.get(j) > key) {
                src.set(j + 1, src.get(j));
                j--;
            }
            src.set(j + 1, key);
        }
    }

}
