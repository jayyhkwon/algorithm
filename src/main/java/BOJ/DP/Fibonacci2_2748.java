package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * BOJ 2748
 * https://www.acmicpc.net/problem/2748
 */
public class Fibonacci2_2748 {

    // 한계값 넣으면 int 범위 초과
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        arr[1] = 1;
        System.out.println(fibonacci(n));

    }

    private static long fibonacci(int n){
        if(n <= 0)
            return 0;

        if(arr[n] > 0)
            return arr[n];

        arr[n] = fibonacci(n-1) + fibonacci(n-2);

        return arr[n];
    }
}
