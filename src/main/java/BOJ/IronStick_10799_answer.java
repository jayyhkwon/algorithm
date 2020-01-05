package BOJ;

import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ (10799)
 * https://www.acmicpc.net/problem/10799
 */
public class IronStick_10799_answer {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine().trim();
        int n = a.length();
        Stack<Integer> s = new Stack<Integer>();
        int ans = 0;
        for (int i=0; i<n; i++) {
            char c = a.charAt(i);
            if (c == '(') {
                s.push(i);
            } else {
                if (s.peek()+1 == i) {
                    s.pop();
                    ans += s.size();
                } else {
                    s.pop();
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
