package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1463
 * https://www.acmicpc.net/problem/1463
 */
public class MakeAOne_1463 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        System.out.println(bottomUp(n));
    }

    private static int topDown(int n){
        if(n == 1)
            return 0;
        if(arr[n] > 0)
            return arr[n];

        arr[n] = topDown(n-1) + 1;

        if(n%2 == 0){
            int tmp = topDown(n/2) + 1;
            if(arr[n] > tmp)
                arr[n] = tmp;
        }

        if(n%3 == 0){
            int tmp = topDown(n/3) + 1;
            if(arr[n] > tmp)
                arr[n] = tmp;
        }
        return arr[n];
    }

    private static int bottomUp(int n){
        arr[1] = 0;
        for(int i=2; i<arr.length; i++){
            arr[i] = arr[i-1] + 1;
            if(i % 2 == 0 && arr[i] > arr[i/2] + 1)
                arr[i] = arr[i/2] + 1;
            if(i % 3 == 0 &&  arr[i] > arr[i/3] + 1)
                arr[i] = arr[i/3] + 1;
        }
        return arr[n];
    }


}
