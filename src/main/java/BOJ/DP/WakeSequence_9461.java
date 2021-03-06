package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 9461
 * https://www.acmicpc.net/problem/9461
 */
public class WakeSequence_9461 {

    // 한계값 넣으면 int 범위 초과
    private static long[] arr = new long[100+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        // P(n) : 나선에 있는 정삼각형의 변의 길이
        // P(1),P(2) ... P(10) 정도까지 나열하면 규칙을 발견할 수 있다
        // P(n) = P(n-1) + P(n-5) (n>5)
        while(testCase-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(solve(n));
        }
    }

    private static long solve(int n) {
        if(arr[n] > 0)
            return arr[n];
        arr[n] = solve(n-5) + solve(n-1);
        return arr[n];
    }
}
