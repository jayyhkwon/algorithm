package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 1934
 * https://www.acmicpc.net/problem/1934
 * LCD * GCD = A * B
 */
public class LCD_1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        int idx = 0;
        while(n-- > 0){
            int[] numbers = Arrays.asList(br.readLine().split("\\s")).stream().mapToInt(Integer::parseInt).toArray();
            int lcd = (numbers[0] * numbers[1]) / gcd(numbers[0],numbers[1]);
            answer[idx] = lcd;
            idx++;
        }

        for(int num : answer)
            System.out.println(num);
    }

    private static int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a%b);
    }


}
