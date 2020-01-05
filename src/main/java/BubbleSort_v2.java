import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size;
        size = Integer.parseInt(br.readLine());
        int[] list = new int[size];

        for(int i=0; i<size; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i=size-1; i>0; i--) {
            cnt++;
            boolean change = false;
            for(int j=0; j<i; j++){
                if(list[j] > list[j+1]){
                    change = true;
                    swap(list,j);
                }
            }
            if(change == false){
                System.out.println(cnt);
                break;
            }
        }
    }

    public static void swap(int[] list, int idx){
        int tmp = list[idx];
        list[idx] = list[idx+1];
        list[idx+1] = tmp;
    }
}
