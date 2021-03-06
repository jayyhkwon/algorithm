package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 6588
 * 골드바흐의 추측
 * https://www.acmicpc.net/problem/6588
 */
public class Goldbach_6588 {

    private static boolean[] prime = new boolean[1000000+1];

    public static void main(String[] args) throws IOException {
        eratosthenes(prime);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        while((n = Integer.parseInt(br.readLine())) != 0){
            int[] answer = getTwoOfPrime(n);
            if(isValid(answer))
                System.out.printf("%d = %d + %d\n",n,answer[0],answer[1]);
            else
                System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    private static void eratosthenes(boolean[] input) {
        input[1] = true;
        for (int i = 2; i < input.length; i++) {
            for (int j = 2 * i; j < input.length; j += i) { // j=i*i로 하면 stackoverflow 발생할 수 있다
                input[j] = true; // 지워진 경우
            }
        }
    }


    private static int[] getTwoOfPrime(int n){
        int[] TwoOfPrime = new int[2];
        for(int i=n-1; i>=0; i--){
            if(isPrime(i)){
                if(isPrime(n-i)){
                    TwoOfPrime[0] = n-i;
                    TwoOfPrime[1] = i;
                    break;
                }
            }
        }
        return TwoOfPrime;
    }

    private static boolean isPrime(int n){
        return prime[n] == false;
    }

    private static boolean isValid(int[] input){
        return input[0] != 0 && input[1] != 0;
    }
}
