package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BOJ 1978
 * https://www.acmicpc.net/problem/1978
 */
public class Prime_1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] number = Arrays.asList(br.readLine().split("\\s")).stream().mapToInt(Integer::parseInt).toArray();
        List<Boolean> count = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(isPrime(number[i]))
                count.add(true);
        }

        System.out.println(count.size());


    }

    private static boolean isPrime(int n){
        if(n<2)
            return false;
        for(int i=2; i*i<=n; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
