package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringReverse {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        reverseWithStackOnTagCondition(s);
    }

    // StringBuilder를 이용한 방법
    // 가장 간단한 알고리즘이나 문자열이 커질 경우
    // String과 StringBuilder를 사용하여 비효율적이다.
    public static String reverseWithStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();

    }

    // 반대편 문자열과 치환하는 알고리즘
    // StringBuilder만을 사용하므로 효율적이다.
    public static String reverseWithOtherEnd(String s) {
        final StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() / 2; i++) {
            final char tmp = sb.charAt(i);
            final int otherEnd = sb.length() - i - 1;
            sb.setCharAt(i, sb.charAt(otherEnd));
            sb.setCharAt(otherEnd, tmp);
        }
        return sb.toString();
    }

    public static String reverseWithStack(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            stack.add(c);
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    // 태그는 뒤집지 않는 조건 && 단어별 뒤집기
    // 시간복잡도 : O(n) -> 모든 단어가 스택에 들어갔다가 나오는 경우
    public static void reverseWithStackOnTagCondition(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        boolean isTag = false;

        for (char c : chars) {
            if (c == '<') {
                print(stack);
                isTag = true;
                System.out.print(c);

            } else if (c == '>') {
                isTag = false;
                System.out.print(c);
            } else if (isTag)
                System.out.print(c);
            else {
                if (c == ' ') {
                    print(stack);
                    System.out.print(c);
                } else {
                    stack.add(c);
                }
            }
        }
        print(stack);
    }

    private static void print(Stack<Character> stack) {
        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }


}
