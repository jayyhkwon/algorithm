package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 15990
 * https://www.acmicpc.net/problem/15990
 */
public class OneTwoThree5_15990 {

    private static long[][] arr = new long[100000+1][4];
    private static long mod = 1000000009L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // D(n) : n을 1,2,3의 합으로 나타낼 수 있는 경우의 수
        // D(n 123) = D(n-1 23) + D(n-2 13) + D(n-3 12)
        //1437690563

        solve();
        while(t-- >0){
            int number = Integer.parseInt(br.readLine());
            System.out.println((arr[number][1] + arr[number][2] + arr[number][3])%mod);
        }
    }

    private static void solve() {
        arr[1][1] = 1;
        arr[1][2] = 0;
        arr[1][3] = 0;

        arr[2][1] = 0;
        arr[2][2] = 1;
        arr[2][3] = 0;

        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 1;

        for(int i=4; i<=100000; i++){
            arr[i][1] = (arr[i-1][2] + arr[i-1][3])%mod;
            arr[i][2] = (arr[i-2][1] + arr[i-2][3])%mod;
            arr[i][3] = (arr[i-3][1] + arr[i-3][2])%mod;
        }
    }


}
