package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 17087
 * https://www.acmicpc.net/problem/17087
 */
public class LCD_17087 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.asList(br.readLine().split("\\s")).stream().mapToInt(Integer::parseInt).toArray();
        int n = line[0];
        int myPosition = line[1];

        int[] brotherPosition = Arrays.asList(br.readLine().split("\\s")).stream().mapToInt(Integer::parseInt).toArray();
        int[] difference = new int[n];

        for(int i=0; i<n; i++){
            difference[i] = Math.abs(brotherPosition[i]- myPosition);
        }

        int gcd = difference[0];
        for(int i=1; i<difference.length; i++){
            gcd = gcd(gcd,difference[i]);
        }

        System.out.println(gcd);
    }

    private static int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a%b);
    }
}
