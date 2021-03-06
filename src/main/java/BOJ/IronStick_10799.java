package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ (10799)
 * https://www.acmicpc.net/problem/10799
 */
public class IronStick_10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = br.readLine().toCharArray();
        Stack<Integer> leftBrackets = new Stack<>();
        List<Integer> razer = new ArrayList<>();
        int pieces = 0;

        for (int i = 0; i < brackets.length; i++) {

            switch (brackets[i]) {
                case '(':
                    leftBrackets.push(i);
                    break;

                case ')':
                    int left = leftBrackets.pop();
                    if (i - left == 1) { // 레이저인 경우
                        razer.add(i);
                    } else { // 막대인 경우
                        int razerOnStick = 0;
                        for (int razerIdx : razer) {
                            if (razerIdx < i && razerIdx > left) {
                                razerOnStick++;
                            }
                        }
                        if (razerOnStick > 0) {
                            pieces += razerOnStick + 1;
                        }
                    }
                    break;
            }
        }

        System.out.println(pieces);
    }
}
