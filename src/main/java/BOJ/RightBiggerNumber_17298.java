package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


/**
 * BOJ 17298
 * https://www.acmicpc.net/problem/17298
 */
public class RightBiggerNumber_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] number = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n];

        solve(n, number, answer);
    }

    private static void solve(int n, int[] number, int[] answer) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int num;
        for (int i = 1; i < n; i++ ){
            num = number[i];
            if(stack.isEmpty()){
                stack.push(i);
            }
            while(!stack.isEmpty() && number[stack.peek()] < num) {
                answer[stack.pop()] = number[i];
            }
            stack.push(i);
        }
        if(!stack.isEmpty()){
            int size = stack.size();
            for(int i=0; i < size; i++){
                answer[stack.pop()] = -1;
            }
        }
        print(answer);
    }

    private static void timeOut(int n, int[] number, int[] answer) {
        for (int i = 0; i < n; i++) {
            int num = number[i];
            int bigger = -1;
            for (int j = i + 1; j < n; j++) {
                if (num < number[j]) {
                    bigger = number[j];
                    break;
                }
            }
            answer[i] = bigger;
        }
        print(answer);
    }

    private static void print(int[] answer) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++)
            sb.append(answer[i] + " ");
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());

    }
}
