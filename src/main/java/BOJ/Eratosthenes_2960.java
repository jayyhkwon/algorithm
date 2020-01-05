package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BOJ 2960
 * https://www.acmicpc.net/problem/2960
 */
public class Eratosthenes_2960 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("\\s");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int answer = eratosthenes(new boolean[n+1],k);
        System.out.println(answer);
    }

    private static int eratosthenes(boolean[] input, int k){
        List<Integer> answer = new ArrayList<>();
        for(int i=2; i<input.length; i++){
            if(input[i] == false) { // 안 지워진 경우
                answer.add(i);
            }
            for(int j=2*i; j<input.length; j+=i){ // j=i*i로 하면 stackoverflow 발생할 수 있다
                if(input[j] == false)
                    answer.add(j);
                input[j] = true; // 지워진 경우
            }
        }
        return answer.get(k-1);
    }
}
