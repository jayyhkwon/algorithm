package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * BOJ 11052
 * https://www.acmicpc.net/problem/11052
 */
public class CardBuy_11052 {

    private static int[] arr;
    private static int[] prices;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        prices = Arrays.asList(br.readLine().split("\\s")).stream().mapToInt(Integer::parseInt).toArray();
        // D(n) : n개의 카드를 사는데 지불하는 최대 금액
        // D(n-i) + P[i]
        arr = new int[n + 1];
        solve(n);
        System.out.println(arr[n]);

    }

    private static void solve(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[i] < arr[i - j] + prices[j - 1])
                    arr[i] = arr[i - j] + prices[j - 1];
            }
        }
    }
}
