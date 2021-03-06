package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 11053
 * 가장 긴 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11053
 */
public class BOJ_11053 {

    private static int[] answer;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        // D(i) : A[1]... A[i] 수열에서 A[i]를 마지막으로 하는 가장 긴 증가하는 수열의 길이
        // D(i) = max(D[j]) + 1 ( j<i, A[j] < A[i] )
        answer = new int[n];
        solve(num);
        System.out.println(Arrays.stream(answer).max().getAsInt());
    }

    private static void solve(int[] num) {
        for(int i=0; i< answer.length; i++){
            answer[i] = 1;
            for(int j=0; j<i; j++) {
                if(num[j] < num[i] && answer[i] < answer[j]+1){
                    answer[i] = answer[j] + 1;
                }
            }
        }
    }


}
