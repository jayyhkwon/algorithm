package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1158
 * https://www.acmicpc.net/problem/1158
 */

public class JosePhus_1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("\\s");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        while (!deque.isEmpty()){
            cnt++;
            if(deque.size() == 1){
                result.add(deque.removeFirst());
                break;
            }

            if(cnt == k){
                result.add(deque.removeFirst());
                cnt = 0;
            }
            else{
                Integer pushed = deque.pollFirst();
                deque.addLast(pushed);
            }
        }

        print(result);
    }

    private static void print(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        result.forEach(x -> sb.append(x+", "));
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }
}
