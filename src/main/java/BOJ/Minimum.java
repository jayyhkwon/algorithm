package BOJ;

import java.util.ArrayList;
import java.util.List;

public class Minimum {

    private static int NOT_EXIST = Integer.MAX_VALUE;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {

    }

    private static void solve(int[] num) {
        int min = min(num);
        answer.add(min);

        for(int i=0; i<num.length; i++){
            min = min(num,min);
            if(min == NOT_EXIST)
                break;
            answer.add(min);
        }
    }

    private static int min(int[] num) {
        int smallest = NOT_EXIST;
        for (int i = 0; i < num.length; i++) {
            if(smallest > num[i]){
                smallest = num[i];
            }
        }
        return smallest;
    }

    private static int min(int[] num, int standard) {
        int smallest = NOT_EXIST;
        for (int i = 0; i < num.length; i++) {
            if(smallest == num[i])
                continue;
            if(num[i] > standard && smallest > num[i])
                smallest = num[i];
        }
        return smallest;
    }

    private static int minIdx(int[] num) {
        int smallest = NOT_EXIST;
        int idx = -1;
        for (int i = 0; i < num.length; i++) {
            if(smallest > num[i]){
                smallest = num[i];
                idx = i;
            }
        }
        return idx;
    }

    private static int minIdx(int[] num, int standard) {
        int smallest = NOT_EXIST;
        int idx = -1;
        for (int i = 0; i < num.length; i++) {
            if(smallest == num[i])
                continue;
            if(num[i] > standard && smallest > num[i]){
                smallest = num[i];
                idx = i;
            }
        }
        return idx;
    }
}
