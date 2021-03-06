package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 14002
 * 가장 긴 증가하는 부분 수열4
 * https://www.acmicpc.net/problem/14002
 */
public class BOJ_14002 {

    private static int[] number;
    private static int[] answer;
    private static int[] previous;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        number = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        // D(i) : A[1]...A[i]를 하는 수열 A에서 A[i]를 마지막으로 하는 가장 긴 증가하는 수열의 길이
        // D(i) = max(D(j)) + 1 (j<i, A[j] < A[i])
        // + 백트래킹
        answer = new int[n];
        previous = new int[n];
        solve(number);
        System.out.println(Arrays.stream(answer).max().getAsInt());
        go(findMaxValueIdx());

    }

    private static int findMaxValueIdx() {
        int idx = -1;
        int max = 0;
        for(int i=0; i<answer.length; i++){
            if(max < answer[i]) {
                max = answer[i];
                idx = i;
            }
        }
        return idx;
    }

    private static void solve(int[] number) {
        for(int i=0; i<number.length; i++){
            answer[i] = 1;
            previous[i] = -1;
            for(int j=0; j<i; j++) {
                if(number[j] < number[i] && answer[i] < answer[j] + 1){
                    answer[i] = answer[j] + 1;
                    previous[i] = j;
                }
            }
        }
    }

    private static void go(int idx){
        if(idx == -1)
            return;
        go(previous[idx]);
        System.out.print(number[idx] + " ");
    }
}

