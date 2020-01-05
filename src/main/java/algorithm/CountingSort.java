package algorithm;

import java.util.Arrays;

/**
 * quickSort vs countingSort
 *  1. 숫자형 제외하고 비교불가
 *  2. largest - smallest 값 클수록 공간 낭비 + 시간 낭비
 *  quickSort 선호됨
 */

public class CountingSort {

    public static int[] sort(int[] input) {

        int max = Arrays.stream(input).max().getAsInt();
        int[] result = new int[input.length];
        int[] countArray = new int[max + 1];

        // countArray[i]는 i와 같은 원소의 개수를 나타낸다.
        for (int i = 0; i < input.length; i++) {
            countArray[input[i]]++;
        }

        //countArray[i]는 이제 i보다 작거나 같은 원소의 개수를 나타낸다.
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }

        for (int i = input.length - 1; i >= 0; i--) {
            result[countArray[input[i]] - 1] = input[i];
            countArray[input[i]]--;
        }

        return result;
    }


}
